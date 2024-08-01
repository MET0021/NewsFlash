package com.example.newsflash.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsflash.api.NewsApp
import com.example.newsflash.model.NewsArticle
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.util.Locale

class NewsViewModel: ViewModel () {
    private val TAG = NewsViewModel::class.java.simpleName

    private val _news = MutableLiveData<List<NewsArticle>>()
    val news : LiveData<List<NewsArticle>> = _news

    fun getNewsList(){
        viewModelScope.launch {
            try {
                val response = NewsApp.newsService.getTopHeadlines(Locale.getDefault().country).awaitResponse()
                if (response.isSuccessful) {
                    response.body()?.let {newsResponse ->
                        _news.postValue(newsResponse.articles)
                    }
                } else {
                    Log.e(TAG, "Error : ${response.message()}")
                }
            } catch (e :Exception){
                Log.e(TAG, "getNewsList Error : ${e.message}", )
            }

        }
    }
}