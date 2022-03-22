package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var dataBase: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase = ContactDataBase.getDatabase(this)

        GlobalScope.launch {
            dataBase.contactdao().insertContact(Contact(0,"Piyush","8769541230"))
        }

         dataBase.contactdao().getContact().observe(this, Observer {

                Log.d("RoomData",it.toString())
            })
     }

}