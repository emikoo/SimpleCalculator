package com.example.firstkotlinproject.data.local

import android.app.Application
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.firstkotlinproject.data.models.Publication

// SQLite
@Database(entities = [Publication::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun instagramDao(): InstagramDao
}