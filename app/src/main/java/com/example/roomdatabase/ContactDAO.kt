package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query(value = "SELECT * FROM contact")

    fun getContact(): LiveData<List<Contact>>

}