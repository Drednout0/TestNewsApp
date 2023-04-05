package com.example.testnewsapp.Network

import com.example.testnewsapp.Data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") API_KEY: String
    ): Call<NewsResponse>
}