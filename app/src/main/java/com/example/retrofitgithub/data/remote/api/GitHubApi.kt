package com.example.retrofitgithub.data.remote.api

import com.example.retrofitgithub.domain.model.ReposData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("issues")
    fun getRepos(@Query("state") state: String):Call<ArrayList<ReposData>>
//issues?state=closed

}