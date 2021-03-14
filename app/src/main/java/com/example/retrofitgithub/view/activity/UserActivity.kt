package com.example.retrofitgithub.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.example.retrofitgithub.R
import com.example.retrofitgithub.common.RetrofitClient
import com.example.retrofitgithub.data.remote.api.GitHubApi
import com.example.retrofitgithub.domain.model.ReposData
import com.example.retrofitgithub.domain.model.UserInfo
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.time.format.DateTimeFormatter
import java.util.*

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val key = intent.extras?.get("type").toString()
        val str = intent.extras?.get("data").toString()
        when (key) {

            "user_data" -> {
                setContentView(R.layout.user_card)
               // val retrofit = RetrofitClient.getClient(BASE_URL)
                val interfaceUser = RetrofitClient.retrofit.create(GitHubApi::class.java)
                interfaceUser.getUser(str).enqueue(object : Callback<UserInfo> {
                    override fun onResponse(
                        call: Call<UserInfo>,
                        response: Response<UserInfo>
                    ) {
                        val userInfo = response.body()
                        if (userInfo !== null) pushData(userInfo)


                    }

                    override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
            "user_html" -> {
                setContentView(R.layout.user_web)
                val webView = findViewById<WebView>(R.id.WvUser)
                webView.loadUrl(str)
            }
        }


    }

    fun pushData(user: UserInfo) {

        val image = findViewById<ImageView>(R.id.imageViewU)
        if (user.avatar_url !== null) {
            Picasso.get().load(user.avatar_url).into(image)
        } else {
            image.setImageResource(R.mipmap.ic_launcher)
        }
        val login = findViewById<TextView>(R.id.tvLoginU)
        login.text = user.login
        val name = findViewById<TextView>(R.id.tvNameU)
        name.text = user.name ?: "No name"
        val type = findViewById<TextView>(R.id.tvTypeU)
        type.text = user.type
        val email = findViewById<TextView>(R.id.tvEmailU)
        email.text = user.email ?: "No email"
        val location = findViewById<TextView>(R.id.tvLocationU)
        location.text = user.location ?: "No location"
        val httpUser = findViewById<TextView>(R.id.tvHtmlUrlUserU)
        httpUser.text = user.html_url
        val dateCreat = findViewById<TextView>(R.id.tvCreatDateU)
        dateCreat.text = user.created_at.toString()
        val dateUpdate = findViewById<TextView>(R.id.tvUpdateDateU)
        dateUpdate.text = user.updated_at.toString()


    }
}