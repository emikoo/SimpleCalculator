package com.example.firsthomework.ui

import android.media.Image
import java.io.Serializable

data class City(
    var image: Int,
    var name: String,
    var description: String,
    var createdData: Int,
    var population: Int,
    var square: String,
    var fullDescription: String
):Serializable