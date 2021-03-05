package com.example.retrofitgithub

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("issues")
    fun getRepos(@Query("state") state: String):Call<ArrayList<ReposData>>
//issues?state=closed

}