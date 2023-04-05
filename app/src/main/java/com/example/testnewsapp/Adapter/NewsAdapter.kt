package com.example.testnewsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewsapp.Data.Article
import com.example.testnewsapp.R
import com.example.testnewsapp.databinding.ItemNewsBinding
import java.util.zip.Inflater

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {
    private var articles: List<Article> = emptyList()

    fun setArticles(articles: List<Article>) {
        this.articles = articles
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
         val binding= ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}




