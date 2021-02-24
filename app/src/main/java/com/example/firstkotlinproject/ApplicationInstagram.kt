package com.example.firstkotlinproject

import android.app.Application
import androidx.room.Room
import com.example.firstkotlinproject.data.local.AppDatabase

class ApplicationInstagram: Application() {
    companion object{
        private lateinit var db: AppDatabase
        fun getDatabase(): AppDatabase = db
    }

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "instagram_db")
            .allowMainThreadQueries()
            .build()
    }
}