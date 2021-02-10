package com.example.firstkotlinproject.network

import com.example.firstkotlinproject.models.Meet
import com.example.firstkotlinproject.models.Publication
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

//    //baseUrl = https://lovetest.me
//    @GET("/a_test_1/test_app.json")
//    fun getMeet(): Call<MutableList<Meet>>

    @GET("7f7da1e8006606a7e230268f91c8d7d3/raw/fabcf933dfbf367843b86e220666b3ef2e6f4fc7/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>

    @GET("3589e7a71c4a2de21f0f85493a0bafa7/raw/467b376039068a46297b1f99c0b4f1333e934846/Profile.json")
    fun fetchProfile(): Call<Publication>
}