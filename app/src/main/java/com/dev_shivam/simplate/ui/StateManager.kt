package com.dev_shivam.simplate.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


object StateManager{
    val currentTextState = mutableStateOf("Enter Your text")

    val currentLanguageListState = mutableStateOf(
        mutableListOf(
        "af: Afrikaans",
        "sq: Albanian",
        "am: Amharic",
        "ar: Arabic",
        "hy: Armenian",
        "az: Azerbaijani",
        "eu: Basque",
        "be: Belarusian"
    ))

    val AddLanguagesListState: MutableState<MutableList<String>> = mutableStateOf(
        mutableListOf(
            "af: Afrikaans",
            "sq: Albanian",
            "am: Amharic",
            "ar: Arabic",
            "hy: Armenian",
            "az: Azerbaijani",
            "eu: Basque",
            "be: Belarusian"
        )
    )



    val currentFromLanguageIndexState: MutableState<Int?> = mutableStateOf(null)
    val currentToLanguageIndexState: MutableState<Int?> = mutableStateOf(null)
    


}

