package com.example.retrofitgithub.domain.model

data class ReposData(
    val title: String?,
    val user: User,
    val body: String?,
    val html_url: String?
)