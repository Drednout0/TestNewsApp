package com.example.testnewsapp.Data

data class Article(
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val author: String?,
    val url: String?,
    val publishedAt: String?

)

data class NewsResponse(
    val articles: List<Article>?
)
