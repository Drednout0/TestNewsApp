package com.example.testnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewsapp.Adapter.NewsAdapter
import com.example.testnewsapp.Data.Article
import com.example.testnewsapp.Network.NewsApiClient

class  MainActivity : AppCompatActivity() {
    private val newsAdapter = NewsAdapter()
    private val newsApiClient = NewsApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        newsApiClient.getTopHeadlines(
            country = "us",

            onSuccess = { articles ->
                setData(articles)
            },
            onError = { error ->
                Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setData(articles: List<Article>) {
        newsAdapter.setArticles(articles)
        newsAdapter.notifyDataSetChanged()
    }
}