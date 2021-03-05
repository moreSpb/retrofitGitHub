package com.example.retrofitgithub

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient
{
fun getClient( baseURL:String):Retrofit{
val r=Retrofit.Builder()
    .baseUrl(baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    return r
}
}