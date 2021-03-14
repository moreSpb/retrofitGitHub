package com.example.retrofitgithub.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitgithub.R
import com.example.retrofitgithub.domain.model.ReposData
import com.squareup.picasso.Picasso

class AdapterRepos(
    private val userAction: (ReposData) -> Unit,
    private val loginAction: (ReposData) -> Unit
) : RecyclerView.Adapter<AdapterRepos.ReposHolder>() {

    private val dataSet = mutableListOf<ReposData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.repos_item, parent, false)
        return ReposHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReposHolder, position: Int) {
        val reposItem = dataSet[position]

        if (reposItem.user.avatar_url !== null) {
            Picasso.get().load(reposItem.user.avatar_url).into(holder.image)
        } else {
            holder.image.setImageResource(R.mipmap.ic_launcher)
        }

        val stub = "No Data"
        holder.login.text = reposItem.user.login ?: stub
        holder.type.text = reposItem.user.type ?: stub
        holder.htmlUrlUser.text = reposItem.user.html_url ?: stub
        holder.title.text = reposItem.title ?: stub
        holder.htmlUrlPost.text = reposItem.html_url ?: stub
        holder.body.text = reposItem.body ?: stub
    }

    override fun getItemCount(): Int = dataSet.size

    fun replaceData(data: List<ReposData>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

    inner class ReposHolder(viewRepos: View) : RecyclerView.ViewHolder(viewRepos),
        View.OnClickListener {

        val image = viewRepos.findViewById<ImageView>(R.id.imageView)
        val login = viewRepos.findViewById<TextView>(R.id.tvLogin)
        val type = viewRepos.findViewById<TextView>(R.id.tvType)
        val htmlUrlUser = viewRepos.findViewById<TextView>(R.id.tvHtmlUrlUser)
        val title = viewRepos.findViewById<TextView>(R.id.tvTitle)
        val htmlUrlPost = viewRepos.findViewById<TextView>(R.id.tvHtmlUrlPost)
        val body = viewRepos.findViewById<TextView>(R.id.tvBody)

        init {
            image.setOnClickListener(this)
            login.setOnClickListener(this)
            htmlUrlUser.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val item = dataSet[adapterPosition]
            when (v?.id) {
                R.id.imageView, R.id.tvLogin -> loginAction(item)
                R.id.tvHtmlUrlUser -> userAction(item)
            }
        }
    }
}