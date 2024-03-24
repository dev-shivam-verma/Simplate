package com.dev_shivam.simplate.data

data class TranslationRequest(
    val sourceLanguage: String,
    val targetLanguage: String,
    val text: String
)
