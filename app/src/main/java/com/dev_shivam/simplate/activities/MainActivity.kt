package com.dev_shivam.simplate.activities


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev_shivam.simplate.data.LanguagesResponse
import com.dev_shivam.simplate.retrofit.BASE_URL_TRANSLATOR_API
import com.dev_shivam.simplate.retrofit.TRANSLATION_HOST
import com.dev_shivam.simplate.retrofit.TRANSLATOR_API_KEY
import com.dev_shivam.simplate.retrofit.TranslatorsMethods
import com.dev_shivam.simplate.ui.screens.AddLanguagesScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddLanguagesScreen()
        }


        Log.d("Retrofit", "Retrofit Method called")


        retrofitInstance.getLanguages(TRANSLATOR_API_KEY, TRANSLATION_HOST)
            .enqueue(object : Callback<LanguagesResponse?> {
                override fun onResponse(
                    call: Call<LanguagesResponse?>,
                    response: Response<LanguagesResponse?>
                ) {
                    if (response.isSuccessful) {
                        val LanguagesList = response.body()?.data?.languages
                        LanguagesList?.forEach {
                            Log.d("Retrofit successfullls",it.name)
                        }
                    }
                }

                override fun onFailure(
                    call: Call<LanguagesResponse?>,
                    t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}







