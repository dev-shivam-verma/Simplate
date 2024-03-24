package com.dev_shivam.simplate.roomdatabase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev_shivam.simplate.data.Language
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Languagetable::class), version = 1)
abstract class LanguageDb: RoomDatabase() {
    abstract fun getLanguageDb(): LanguageDao
}


object LanguageDatabase{
    private var myDB: LanguageDb? = null

    fun getLanguageDb(context: Context): LanguageDb{
        if (myDB == null){
            myDB = Room.databaseBuilder(context,
                LanguageDb::class.java,
                "MyLanguagedb")
                .build()
            return myDB!!
        }

        return myDB!!
    }
}

