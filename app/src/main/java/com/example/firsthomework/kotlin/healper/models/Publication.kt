package com.example.firsthomework.kotlin.healper.models

import com.example.firsthomework.kotlin.healper.ui.image_list.ImageCarouselFragment

data class Publication (
    val name: String,
    val phoneNumber: String,
    val age: String,
    val image: MutableList<String>,
    var isFavorite: Boolean = false
)

val imageArray = mutableListOf<String>().apply {
    add("https://i1.sndcdn.com/artworks-twVuPijgKdMZwLOo-GAzEuQ-t500x500.jpg")
    add("https://i1.sndcdn.com/avatars-nwffhCdGSzMy9IY1-EruAgA-t240x240.jpg")
    add("https://i1.sndcdn.com/artworks-000204747428-j19cos-t500x500.jpg")
    add("https://e-talentbank.co.jp/wp-content/uploads/2019/08/6673c67b52df1a90ac381fba4f80ca84-1600x1600.png")
    add("https://static.wikia.nocookie.net/vocaloid/images/f/f4/Seeeeecun_icon.jpg/revision/latest?cb=20181222132429")
}

fun changeState(item: Publication, array: MutableList<Publication>) {
    for (i in array) {
        if (i == item) item.isFavorite = !item.isFavorite
    }
}

fun getFavoriteArray() = mutableListOf<Publication>().apply {    addAll(publicationsArray.filter { it.isFavorite }) }

val publicationsArray = mutableListOf<Publication>().apply {
    add(Publication("Tom", "999777222107", "80", imageArray))
    add(Publication("Andrew", "999777222107", "30", imageArray))
    add(Publication("Sara", "999777222107", "20", imageArray))
    add(Publication("Mikel", "999777222107", "30", imageArray))
    add(Publication("Kristian", "999777222107", "60", imageArray))
    add(Publication("Kate", "999777222107", "50", imageArray))
    add(Publication("Jane", "999777222107", "40", imageArray))
}