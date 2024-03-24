package com.dev_shivam.simplate.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dev_shivam.simplate.data.Language
import com.dev_shivam.simplate.ui.StateManager
import com.dev_shivam.simplate.ui.screens.MainActivityScreen
import com.dev_shivam.simplate.ui.theme.SimplateTheme
import com.dev_shivam.simplate.viewmodels.LanguageViewModel
import com.dev_shivam.simplate.viewmodels.LanguageViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    private lateinit var viewmodel: LanguageViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(owner = this, factory = LanguageViewModelFactory(this)).get(
            LanguageViewModel::class.java
        )
        setContent {
            SimplateTheme {
                MainActivityScreen(
                    onAddLanguage = ::onAddLanguage,
                    onTranslate = viewmodel::doTranslation
                )
            }
        }
    }


    override fun onResume() {
        super.onResume()
        viewmodel.loadLanguages()
    }

    private fun onAddLanguage() {
        Intent(this, AddLanguageActivity::class.java).also {
            startActivity(it)
        }
    }
}







