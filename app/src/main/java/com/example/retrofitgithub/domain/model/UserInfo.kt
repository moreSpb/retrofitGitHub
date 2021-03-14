package com.example.retrofitgithub.domain.model

import java.util.*

data class UserInfo(
    override val login: String,
    override val avatar_url: String?,
    override val html_url: String,
    override val type: String,
    val name: String?,
    val location: String?,
    val email: String?,
    val created_at: Date,
    val updated_at: Date
) : UserInterface
