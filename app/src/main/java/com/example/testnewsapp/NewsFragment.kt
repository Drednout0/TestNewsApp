package com.example.testnewsapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewsapp.Adapter.NewsAdapter
import com.example.testnewsapp.Network.NewsApiClient

class NewsFragment : Fragment(R.layout.fragment_news) {
    private val newsAdapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val newsApiClient = NewsApiClient()

        newsApiClient.getTopHeadlines(
            country = "us",

            onSuccess = { articles ->
                newsAdapter.setArticles(articles)

            },
            onError = { error ->
                Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
            }
        )
    }
}