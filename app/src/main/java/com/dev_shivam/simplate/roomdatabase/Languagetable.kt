package com.dev_shivam.simplate.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("Language")
data class Languagetable(
    val name: String,
    val code: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)