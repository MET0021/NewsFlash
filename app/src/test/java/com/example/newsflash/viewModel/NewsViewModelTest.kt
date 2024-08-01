package com.example.newsflash.viewModel

import org.junit.Before
import org.junit.Test


class NewsViewModelTest {

    private lateinit var viewModel: NewsViewModel

    @Before
    fun setUp() {
        viewModel = NewsViewModel()

    }

    @Test
    fun `getNewsList should update news LiveData`(){
        viewModel.getNewsList()
        val news = viewModel.news.value
        assert(news != null)
    }
}