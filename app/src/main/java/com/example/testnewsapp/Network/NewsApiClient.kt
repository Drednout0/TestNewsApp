package com.example.testnewsapp.Network

import com.example.testnewsapp.Data.Article
import com.example.testnewsapp.Data.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsApiClient {
    private val service: NewsApiService = RetrofitClient.create()

    fun getTopHeadlines(
        country: String,
        onSuccess: (List<Article>) -> Unit,
        onError: (String) -> Unit
    ) {
        service.getTopHeadlines(country, RetrofitClient.API_KEY).enqueue(object :
            Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                if (response.isSuccessful) { // Проверка успешности ответа
                    val articles = response.body()?.articles ?: emptyList()
                    onSuccess(articles) // Обратный вызов при успехе
                } else {
                    onError("Ошибка запроса") // Обратный вызов при ошибке
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                onError(t.localizedMessage ?: "Неизвестная ошибка") // Обратный вызов при ошибке
            }
        })
    }
}