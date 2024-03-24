package com.dev_shivam.simplate.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev_shivam.simplate.data.Language
import com.dev_shivam.simplate.data.LanguagesResponse
import com.dev_shivam.simplate.data.TranslationResponse
import com.dev_shivam.simplate.retrofit.retrofit
import com.dev_shivam.simplate.roomdatabase.LanguageDatabase
import com.dev_shivam.simplate.roomdatabase.Languagetable
import com.dev_shivam.simplate.ui.StateManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LanguageViewModel(context: Context) : ViewModel() {

    private val languageDao = LanguageDatabase.getLanguageDb(context).getLanguageDb()
    private val retrofitInstance = retrofit.RetrofitInstance()

    fun loadLanguages() {
        // To clear the previous values
        StateManager.currentLanguageListState.clear()

        viewModelScope.launch(Dispatchers.IO) {
            languageDao.getAllLanguages().forEach {
                StateManager.currentLanguageListState.add(
                    Language(
                        code = it.code,
                        name = it.name
                    )
                )
            }
        }
    }

    fun deleteAllLanguages() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = languageDao.getAllLanguages()

            list.forEach {
                languageDao.deleteLanguage(it)
            }
        }
    }

    fun loadAddLanguages() {

        viewModelScope.launch(Dispatchers.IO) {
            retrofitInstance.getLanguages().enqueue(object : Callback<LanguagesResponse?> {
                override fun onResponse(
                    p0: Call<LanguagesResponse?>,
                    p1: Response<LanguagesResponse?>
                ) {
                    if (p1.isSuccessful) {
                        val data = p1.body()?.data?.languages
                        StateManager.AddLanguagesListState.clear()
                        data?.forEach {
                            StateManager.AddLanguagesListState.add(it)
                        }
                    }
                }

                override fun onFailure(p0: Call<LanguagesResponse?>, p1: Throwable) {
                    Log.e("Retrofit", p1.message.toString())
                }
            })
        }
    }


    fun addLanguagesToDb() {
        viewModelScope.launch(Dispatchers.IO) {
            val offlineLnList = languageDao.getAllLanguages()

            StateManager.selectedLanguages.forEach {
                val languageTable = Languagetable(it.name, it.code)

                // add language only when it is not present in database already
                if (!ifLanguageSaved(languageTable, offlineLnList))
                    languageDao.insertLanguage(languageTable)
            }
        }
    }

    private fun ifLanguageSaved(
        languagetable: Languagetable,
        listLanguagetable: List<Languagetable>
    ): Boolean {
        for (i in listLanguagetable) {
            if (i.code == languagetable.code)
                return true
        }
        return false
    }

    fun doTranslation() {
        if (StateManager.currentToLanguageIndexState.value != null && StateManager.currentFromLanguageIndexState != null) {
            viewModelScope.launch(Dispatchers.IO) {
                val fromLanguage =
                    StateManager.currentLanguageListState[StateManager.currentToLanguageIndexState.value!!]
                val toLanguage =
                    StateManager.currentLanguageListState[StateManager.currentFromLanguageIndexState.value!!]
                val translationText = StateManager.currentTextState.value



                retrofitInstance.translate(fromLanguage.code, toLanguage.code, translationText).enqueue(object : Callback<TranslationResponse?> {
                    override fun onResponse(
                        p0: Call<TranslationResponse?>,
                        p1: Response<TranslationResponse?>
                    ) {
                        if (p1.isSuccessful){
                            val data = p1.body()?.translationData?.translatedText

                            data?.let {
                                StateManager.translatedText.value = data
                                StateManager.isTranslationStarted.value = true
                            }
                        }
                    }

                    override fun onFailure(p0: Call<TranslationResponse?>, p1: Throwable) {
                        Log.e("Retrofit", p1.message.toString())
                    }
                })
            }
        }
    }
}