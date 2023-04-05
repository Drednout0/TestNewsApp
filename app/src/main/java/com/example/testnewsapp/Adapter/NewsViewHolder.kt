package com.example.testnewsapp.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testnewsapp.Data.Article
import com.example.testnewsapp.databinding.ItemNewsBinding

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.titleTextView.text = article.title
        binding.descriptionTextView.text = article.description
        Glide.with(binding.root.context)
            .load(article.urlToImage)
            .into(binding.imageView)
    }

}