package com.example.retrofitgithub.domain.model

/**
 * Created by Alexander Kolpakov (jquickapp@gmail.com) on 06-Mar-21
 * https://github.com/bitvale
 */
data class User(
    val login: String?,
    val avatar_url: String?,
    val html_url: String?,
    val type: String?,
    val url: String?// Не используется пока, для отображения страницы USER
)