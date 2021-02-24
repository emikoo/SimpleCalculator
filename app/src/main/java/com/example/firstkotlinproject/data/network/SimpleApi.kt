package com.example.firstkotlinproject.data.network

import com.example.firstkotlinproject.data.models.Publication
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

//    //baseUrl = https://lovetest.me
//    @GET("/a_test_1/test_app.json")
//    fun getMeet(): Call<MutableList<Meet>>

    @GET("ba5ce31490fbdf602238defc6a673017/raw/e41ed4c12626d5448a3fed7f330f584ba6544523/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>

    @GET("cc8cf61db98d6c9f9c3f5e41eee329bc/raw/52ec1e0135f8c38844f659f968a1e6cdef30cbc8/Profile.json")
    fun fetchProfile(): Call<Publication>
}