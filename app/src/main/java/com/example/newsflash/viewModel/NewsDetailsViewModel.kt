package com.example.newsflash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsflash.model.NewsArticle

class NewsDetailsViewModel : ViewModel() {
    private val TAG = NewsDetailsViewModel::class.java.simpleName
    private val _newsArticleDetail = MutableLiveData<NewsArticle?>()
    val newsArticleDetail: LiveData<NewsArticle?> = _newsArticleDetail

    fun getArticleDetails(newsArticle : NewsArticle?) {
        _newsArticleDetail.postValue(newsArticle)
    }

}
