package com.example.firsthomework.kotlin.healper.models

data class Name (
    val name: String,
    val phoneNumber: String,
    val age: String,
    val image: String
)

val nameArray = mutableListOf<Name>().apply {
    add(Name("Tom", "999777222107", "80", ""))
    add(Name("Andrew", "999777222107", "30", ""))
    add(Name("Sara", "999777222107", "20", ""))
    add(Name("Mikel", "999777222107", "30", ""))
    add(Name("Kristian", "999777222107", "60", ""))
    add(Name("Kate", "999777222107", "50", ""))
    add(Name("Jane", "999777222107", "40", ""))
}