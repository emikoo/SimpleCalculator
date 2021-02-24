package com.example.firstkotlinproject.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstkotlinproject.data.models.Publication

@Dao
interface InstagramDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublications(data: List<Publication>?)

    @Query("SELECT * FROM publication")
    fun getPublications(): List<Publication>
}