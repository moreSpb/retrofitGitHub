package com.example.retrofitgithub

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterRepos(val repos: ArrayList<ReposData>) :
    RecyclerView.Adapter<AdapterRepos.ReposHolder>() {
    class ReposHolder(viewRepos: View) : RecyclerView.ViewHolder(viewRepos) {

        val image = viewRepos.findViewById<ImageView>(R.id.imageView)
        val login = viewRepos.findViewById<TextView>(R.id.tvLogin)
        val type = viewRepos.findViewById<TextView>(R.id.tvType)
        val htmlUrlUser = viewRepos.findViewById<TextView>(R.id.tvHtmlUrlUser)
        val title = viewRepos.findViewById<TextView>(R.id.tvTitle)
        val htmlUrlPost = viewRepos.findViewById<TextView>(R.id.tvHtmlUrlPost)
        val body = viewRepos.findViewById<TextView>(R.id.tvBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.repos_item, parent, false)
        return ReposHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReposHolder, position: Int) {
        val reposItem = repos[position]

        if (reposItem.user.avatar_url !== null)
            Picasso.get().load(reposItem.user.avatar_url).into(holder.image)
        else holder.image.setImageResource(R.mipmap.ic_launcher)

        holder.login.text = reposItem.user?.login ?: "No Data"
        holder.type.text = reposItem.user?.type ?: "No Data"
        holder.htmlUrlUser.text = reposItem.user?.html_url ?: "No Data"
        holder.title.text = reposItem.title ?: "No Data"
        holder.htmlUrlPost.text = reposItem.html_url ?: "No Data"
        holder.body.text = reposItem.body ?: "No Data"


    }

    override fun getItemCount() = repos.size

}