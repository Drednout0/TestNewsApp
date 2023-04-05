package com.example.testnewsapp.Adapter

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.testnewsapp.Data.Article
import com.example.testnewsapp.databinding.ItemNewsBinding

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    private val requestOptions = RequestOptions().transform(RoundedCorners(40))
    private val context = binding.root.context

    fun bind(article: Article) {
        val clickButton = binding.materialButton

        binding.titleTextView.text = article.title
        binding.authorTextView.text = article.author
        binding.descriptionTextView.text = article.description

        clickButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            context.startActivity(intent)
        }

        Glide.with(binding.root.context)
            .load(article.urlToImage)
            .apply(requestOptions)
            .into(binding.imageView)
    }
}