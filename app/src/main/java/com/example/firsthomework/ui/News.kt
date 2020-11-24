package com.example.firsthomework.ui

import java.io.Serializable

data class News(
    var image: String,
    var title: String,
    var subtitle: String,
    var fullNews: String
):Serializable