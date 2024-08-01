package com.example.newsflash.api

import android.app.Application
import android.util.Log
import com.example.newsflash.model.NewsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApp : Application() {

    companion object {
        lateinit var instance: NewsApp
        const val BASE_URL = "https://newsapi.org/"

        private val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        private val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsService : NewsService = retrofit.create(NewsService::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}