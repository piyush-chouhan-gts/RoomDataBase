package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")

data class Contact(

    @PrimaryKey(autoGenerate = true)

    val id: Long,
    val name: String,
    val phone: String

)