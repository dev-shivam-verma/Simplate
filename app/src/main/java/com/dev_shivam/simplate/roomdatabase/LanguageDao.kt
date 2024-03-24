package com.dev_shivam.simplate.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.dev_shivam.simplate.data.Language

@Dao
interface LanguageDao{

    @Upsert
    fun insertLanguage(language: Languagetable)

    @Query("SELECT * FROM Language WHERE code = :code ")
    fun getLanguageFromCode(code: String): Languagetable
    @Query("SELECT * FROM Language")
    fun getAllLanguages(): List<Languagetable>

    @Delete
    fun deleteLanguage(language: Languagetable)
}
