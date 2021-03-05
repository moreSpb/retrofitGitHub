package com.example.retrofitgithub

data class ReposData(
    val title: String?,
    val user: User,
    val body:String?,
    val html_url:String?
)

data class User(
    val login: String?,
    val avatar_url: String?,
    val html_url: String?,
    val type: String?,
    val url:String?// Не используется пока, для отображения страницы USER

)