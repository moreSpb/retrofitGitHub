package com.example.retrofitgithub.data.remote.api

import com.example.retrofitgithub.domain.model.ReposData
import com.example.retrofitgithub.domain.model.UserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("repos/vmg/redcarpet/issues")
    fun getRepos(@Query("state") state: String):Call<ArrayList<ReposData>>
    @GET("users/{login}")
    fun getUser(@Path("login") login:String ):Call<UserInfo>


}