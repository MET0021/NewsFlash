package com.example.newsflash.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


private const val API_KEY = "3d54e808842c4da59e4c075b2b90a0d6"
interface NewsService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>
}