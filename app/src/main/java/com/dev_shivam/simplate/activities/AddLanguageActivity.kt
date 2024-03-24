package com.dev_shivam.simplate.activities

import android.content.ComponentName
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.dev_shivam.simplate.ui.screens.AddLanguagesScreen
import com.dev_shivam.simplate.ui.theme.SimplateTheme
import com.dev_shivam.simplate.viewmodels.LanguageViewModel
import com.dev_shivam.simplate.viewmodels.LanguageViewModelFactory

class AddLanguageActivity : ComponentActivity() {

    private lateinit var viewmodel: LanguageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(
            owner = this,
            factory = LanguageViewModelFactory(this)
        )[LanguageViewModel::class.java]

        setContent {
            SimplateTheme {
                AddLanguagesScreen(
                    onAddSelectedLanguages = {
                        viewmodel.addLanguagesToDb()
                        onBackPressed()
                    },
                    onBackPressed = ::onBackPressed
                )
            }
        }

        viewmodel.loadAddLanguages()
    }
}