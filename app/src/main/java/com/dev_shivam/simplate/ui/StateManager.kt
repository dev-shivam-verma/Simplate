package com.dev_shivam.simplate.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.dev_shivam.simplate.data.Language


object StateManager{
    val currentTextState = mutableStateOf("Enter Your text")
    val translatedText: MutableState<String?> = mutableStateOf(null)
    val isTranslationStarted = mutableStateOf(false)

    val currentLanguageListState= mutableStateListOf<Language>()
    val AddLanguagesListState = mutableStateListOf<Language>()



    var selectedLanguages = mutableStateListOf<Language>()

    val currentFromLanguageIndexState: MutableState<Int?> = mutableStateOf(null)
    val currentToLanguageIndexState: MutableState<Int?> = mutableStateOf(null)

}

