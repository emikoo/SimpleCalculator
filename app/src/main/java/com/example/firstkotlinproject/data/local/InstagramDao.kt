package com.example.firstkotlinproject.data.local

import androidx.room.*
import com.example.firstkotlinproject.data.models.Publication

@Dao
interface InstagramDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublications(data: List<Publication>?)

    @Query("SELECT * FROM publication")
    fun fetchPublications(): List<Publication>

    @Query("SELECT * FROM publication WHERE isFavorite == 1")
    fun fetchFavoritePublications(): List<Publication>

    @Update
    fun updateChangeFavoriteState(data: Publication)
}