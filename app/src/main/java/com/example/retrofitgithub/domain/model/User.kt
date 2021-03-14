package com.example.retrofitgithub.domain.model

/**
 * Created by Alexander Kolpakov (jquickapp@gmail.com) on 06-Mar-21
 * https://github.com/bitvale
 */
data class User(
    override val login: String?,
    override val avatar_url: String?,
    override val html_url: String?,
    override val type: String?,
    val url: String?
) : UserInterface