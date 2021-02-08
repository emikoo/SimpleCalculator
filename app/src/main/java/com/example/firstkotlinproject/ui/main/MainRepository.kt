package com.example.firstkotlinproject.ui.main

import com.example.firstkotlinproject.models.Publication
import com.example.firstkotlinproject.network.RetrofitClient
import com.example.firstkotlinproject.ui.publication.RequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val callback: RequestResult) {

    private var api = RetrofitClient().simpleApi

    fun fetchPublications() {
        api.fetchPublications().enqueue(object: Callback<MutableList<Publication>> {
            override fun onFailure(call: Call<MutableList<Publication>>, t: Throwable) {
                return callback.onFailure(t)
            }

            override fun onResponse(
                call: Call<MutableList<Publication>>,
                response: Response<MutableList<Publication>>
            ) {
                return if (response.body() != null) callback.onSuccess(response.body()!!)
                else callback.onFailure(Throwable("error"))
            }
        })
    }

}