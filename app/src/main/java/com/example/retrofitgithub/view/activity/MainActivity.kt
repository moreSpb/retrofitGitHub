package com.example.retrofitgithub.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.retrofitgithub.R
import com.example.retrofitgithub.common.RetrofitClient
import com.example.retrofitgithub.data.remote.api.GitHubApi
import com.example.retrofitgithub.domain.model.ReposData
import com.example.retrofitgithub.view.adapter.AdapterRepos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

const val BASE_URL = "https://api.github.com/"

class MainActivity : AppCompatActivity() {

    private val adapter: AdapterRepos = AdapterRepos()
   // lateinit var retrofit: Retrofit
    lateinit var ddd:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient.retrofit = RetrofitClient.getClient(BASE_URL)
        val interfaceRepos = RetrofitClient.retrofit.create(GitHubApi::class.java)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRepoc)
        val decor = DividerItemDecoration(this, VERTICAL)
        with(recyclerView) {
            addItemDecoration(decor)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        interfaceRepos.getRepos("closed").enqueue(object : Callback<ArrayList<ReposData>> {
            override fun onResponse(
                call: Call<ArrayList<ReposData>>,
                response: Response<ArrayList<ReposData>>
            ) {
                val data = response.body() ?: return
                adapter.replaceData(data)
            }

            override fun onFailure(call: Call<ArrayList<ReposData>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}