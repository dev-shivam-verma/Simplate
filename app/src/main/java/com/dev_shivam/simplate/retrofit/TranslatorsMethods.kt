package com.dev_shivam.simplate.retrofit

import com.dev_shivam.simplate.data.LanguagesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header

val BASE_URL_TRANSLATOR_API = "https://text-translator2.p.rapidapi.com/"
val TRANSLATOR_API_KEY = "403f297f36msh56c5be4cff0a308p164414jsn33236dd9a7d6"
val TRANSLATION_HOST = "text-translator2.p.rapidapi.com"
interface TranslatorsMethods {


    @GET("/getLanguages")
    fun getLanguages(@Header("X-RapidAPI-Key") apiKey: String,
                     @Header("X-RapidAPI-Host")apiHost: String): Call<LanguagesResponse>

}


object retrofit{
    val retrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL_TRANSLATOR_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create<TranslatorsMethods>()

}