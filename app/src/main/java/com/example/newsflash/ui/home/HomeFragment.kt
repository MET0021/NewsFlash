package com.example.newsflash.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsflash.databinding.HomeFragmentBinding
import com.example.newsflash.model.NewsArticle
import com.example.newsflash.ui.NewsAdapter
import com.example.newsflash.viewModel.NewsDetailsViewModel
import com.example.newsflash.viewModel.NewsViewModel

class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val newsViewModel: NewsViewModel by viewModels()
    private val newsDetailsViewModel: NewsDetailsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsList.layoutManager = LinearLayoutManager(context)
        newsViewModel.news.observe(viewLifecycleOwner) { news ->
            newsAdapter = NewsAdapter(news as MutableList<NewsArticle>?)
            binding.newsList.adapter = newsAdapter
        }
        newsViewModel.getNewsList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}