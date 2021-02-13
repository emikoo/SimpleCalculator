package com.example.firstkotlinproject.models

data class Comment(
    var name: String? = null,
    var message: String? = null,
    var isFavorite: Boolean = false,
    var countOfFavorite: Int = 0
)

//GET - получение данных
//POST - отправка данных
//DELETE - удаление данных
//PUT - изменение данных

//200 - Запрос успешно выполнен
//201 - Успешно создаем запись
//400 - Отправлены/получены не верные данные
//404 - Обратились к не существующей записи
//413 - Передаете больше чем возможно
//500 - Происходят по вине сервера

//200-299 - Успешные запросы
//400-499 - Пробелмные запросы
//500-599 - Ошибки сервера
