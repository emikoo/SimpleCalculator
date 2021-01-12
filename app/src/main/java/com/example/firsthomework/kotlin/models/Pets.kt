package com.example.firsthomework.kotlin.models

import java.io.Serializable

data class Pets(
    var image: String,
    var name: String,
    var height: String,
    var description: String,
    var isLiked: Boolean = false,
    var species: String
) : Serializable

val catArray = mutableListOf<Pets>().apply {
    add(Pets("https://cdn.pixabay.com/photo/2020/05/11/15/38/tom-5158824_960_720.png","Tom", "26cm", "Tom hates Jerry", false, "home"))
    add(Pets("https://cdn.pixabay.com/photo/2020/05/11/15/38/tom-5158824_960_720.png","Kom", "27cm", "Kom hates Perry", true, "home"))
    add(Pets("https://cdn.pixabay.com/photo/2020/05/11/15/38/tom-5158824_960_720.png","Rom", "28cm", "Rom hates Ferry", false, "home"))
    add(Pets("https://cdn.pixabay.com/photo/2020/05/11/15/38/tom-5158824_960_720.png","Mom", "29cm", "Mom hates Gerry", true, "home"))
    add(Pets("https://cdn.pixabay.com/photo/2020/05/11/15/38/tom-5158824_960_720.png","Lom", "30cm", "Lom hates Berry", false, "home"))
}

val dogArray = mutableListOf<Pets>().apply {
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Spike", "50cm", "Spike protects Jerry", false, "home"))
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Lpike", "51cm", "Lpike protects Perry", true, "home"))
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Tpike", "52cm", "Tpike protects Ferry", false, "home"))
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Ppike", "53cm", "Ppike protects Gerry", true, "home"))
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Rpike", "54cm", "Rpike protects Berry", false, "home"))
    add(Pets("https://static.wikia.nocookie.net/tomandjerry/images/0/0f/Quiz-tom-jerry-richtig-03-1035-10110.png/revision/latest?cb=20200118121656", "Dpike", "55cm", "Dpike protects Merry", true, "home"))
}

fun changeState(item: Pets, array: MutableList<Pets>) {
    for (i in array) {
        if (i == item) item.isLiked = !item.isLiked
    }
}

fun getFavoriteArray() = mutableListOf<Pets>().apply {    addAll(catArray.filter { it.isLiked })
    addAll(dogArray.filter { it.isLiked })
}