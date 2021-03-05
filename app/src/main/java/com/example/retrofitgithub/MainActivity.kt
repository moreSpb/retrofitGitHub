package com.example.retrofitgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

const val BASE_URL = "https://api.github.com/repos/vmg/redcarpet/"

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterRepos
    private lateinit var recyclerView: RecyclerView
    private lateinit var data: ArrayList<ReposData>
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit = RetrofitClient.getClient(BASE_URL)
        val interfaceRepos = retrofit.create(GitHubApi::class.java)
        layoutManager = LinearLayoutManager(this)

        recyclerView = findViewById(R.id.recyclerRepoc)
        val decor=DividerItemDecoration(applicationContext,VERTICAL)
        recyclerView.addItemDecoration(decor)
        interfaceRepos.getRepos("closed").enqueue(object : Callback<ArrayList<ReposData>> {
            override fun onResponse(
                call: Call<ArrayList<ReposData>>,
                response: Response<ArrayList<ReposData>>
            ) {
                val data = response.body()
                if (data == null) return
                adapter = AdapterRepos(data)
                recyclerView.layoutManager = layoutManager
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter


            }

            override fun onFailure(call: Call<ArrayList<ReposData>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })


    }
}