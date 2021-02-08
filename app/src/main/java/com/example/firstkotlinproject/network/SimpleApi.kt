package com.example.firstkotlinproject.network

import com.example.firstkotlinproject.models.Meet
import com.example.firstkotlinproject.models.Publication
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

//    //baseUrl = https://lovetest.me
//    @GET("/a_test_1/test_app.json")
//    fun getMeet(): Call<MutableList<Meet>>

    @GET("raw/feddd59ced26e92850a45d5e048ec5c3b277e098/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>
}