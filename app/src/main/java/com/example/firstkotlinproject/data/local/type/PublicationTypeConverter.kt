package com.example.firstkotlinproject.data.local.type

import androidx.room.TypeConverter
import com.example.firstkotlinproject.data.models.Comment
import com.example.firstkotlinproject.data.models.Images
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PublicationTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun imagesToString(data: List<Images>): String{
        return  gson.toJson(data)
    }

    @TypeConverter
    fun toImagesFromString(json: String): MutableList<Images> {
        val listType = object: TypeToken<MutableList<Images>?>() {
        }.type
        return gson.fromJson(json, listType)
    }

    @TypeConverter
    fun commentsToString(data: List<Comment>): String {
        return  gson.toJson(data)
    }

    @TypeConverter
    fun toCommentsFromString(json: String): MutableList<Comment>{
        val listType = object: TypeToken<MutableList<Comment>?>(){
        }.type
        return gson.fromJson(json, listType)
    }
}