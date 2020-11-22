package com.example.firsthomework.ui

import java.io.Serializable

data class News(
    var image: Int,
    var title: String,
    var subtitle: String,
    var fullNews: String
):Serializable