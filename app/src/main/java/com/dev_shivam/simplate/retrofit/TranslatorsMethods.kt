package com.dev_shivam.simplate.retrofit

import com.dev_shivam.simplate.data.LanguagesResponse
import com.dev_shivam.simplate.data.TranslationResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

val BASE_URL_TRANSLATOR_API = "https://text-translator2.p.rapidapi.com/"
val TRANSLATOR_API_KEY = "403f297f36msh56c5be4cff0a308p164414jsn33236dd9a7d6"
val TRANSLATION_HOST = "text-translator2.p.rapidapi.com"
interface TranslatorsMethods {

    @Headers(
        "X-RapidAPI-Key: 403f297f36msh56c5be4cff0a308p164414jsn33236dd9a7d6",
        "X-RapidAPI-Host: text-translator2.p.rapidapi.com"
    )
    @GET("/getLanguages")
    fun getLanguages(): Call<LanguagesResponse>


    @FormUrlEncoded
    @Headers(
        "X-RapidAPI-Key: 403f297f36msh56c5be4cff0a308p164414jsn33236dd9a7d6",
        "X-RapidAPI-Host: text-translator2.p.rapidapi.com"
    )
    @POST("/translate")
    fun translate(@Field("source_language") sourceLanguage: String,
                  @Field("target_language") targetLanguage: String,
                  @Field("text") text: String): Call<TranslationResponse>

}


object retrofit{
    private var retrofitInstance: TranslatorsMethods? = null

    fun RetrofitInstance(): TranslatorsMethods{
        if (retrofitInstance == null){
            retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL_TRANSLATOR_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create<TranslatorsMethods>()

            return retrofitInstance!!
        }
        return retrofitInstance!!
    }

}