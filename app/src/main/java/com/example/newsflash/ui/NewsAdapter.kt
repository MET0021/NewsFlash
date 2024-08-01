package com.example.newsflash.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsflash.R
import com.example.newsflash.databinding.NewsItemBinding
import com.example.newsflash.model.NewsArticle
import com.example.newsflash.ui.newsDetails.NewsDetailsActivity
import com.example.newsflash.ui.newsDetails.NewsDetailsFragment


class NewsAdapter (
    private val news: MutableList<NewsArticle>?,
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news : NewsArticle){
            binding.newsTitle.text = news.title
            binding.newsPoster.load(news.poster){
                placeholder(R.drawable.ic_launcher_foreground)
                fallback(R.drawable.breaking_news)
                }
            binding.newsCard.setOnClickListener {
                val intent = Intent(binding.root.context, NewsDetailsActivity::class.java)
                intent.putExtra(NewsDetailsFragment.NEWS_SELECTED,news)
                binding.root.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news?.get(position)
        if (new != null) {
            holder.bind(new)
        }
    }

    override fun getItemCount(): Int {
        return news?.size ?: 0
    }

}