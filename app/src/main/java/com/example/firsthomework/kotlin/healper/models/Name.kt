package com.example.firsthomework.kotlin.healper.models

import java.io.Serializable

data class Name (
    val name: String
):Serializable

val nameArray = mutableListOf<Name>().apply {
    add(Name("Tom"))
    add(Name("Andrew"))
    add(Name("Sara"))
    add(Name("Mikel"))
    add(Name("Kristian"))
    add(Name("Kate"))
    add(Name("Jane"))
}