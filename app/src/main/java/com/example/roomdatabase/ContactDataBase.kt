package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.lang.ClassCastException

@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactdao(): ContactDAO

    companion object {

        @Volatile
        private var instance: ContactDataBase? = null

        fun getDatabase(context: Context): ContactDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDataBase::class.java, "contactDB"
                    ).build()
                }
            }
            return instance!!
        }
     }
}