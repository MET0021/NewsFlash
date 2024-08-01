package com.example.newsflash.ui.newsDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.newsflash.R

import com.example.newsflash.databinding.NewsDetailsFragmentBinding
import com.example.newsflash.model.NewsArticle
import com.example.newsflash.viewModel.NewsDetailsViewModel

class NewsDetailsFragment : Fragment() {
    private var _binding: NewsDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val newsDetailsViewModel: NewsDetailsViewModel by viewModels()

    companion object {
        val NEWS_SELECTED = "NEWS_SELECTED"
        fun newInstance()= NewsDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity?.intent!!.hasExtra(NEWS_SELECTED)){
            requireActivity().intent.getParcelableExtra<NewsArticle>(NEWS_SELECTED).let {
                newsDetailsViewModel.getArticleDetails(it)
                newsDetailsViewModel.newsArticleDetail.observe(viewLifecycleOwner) { newsDetail ->
                    binding.newsTitle.text = newsDetail?.title
                    binding.newsDescription.text = newsDetail?.description

                    val spannableString = SpannableString(getString(R.string.see_all_article))
                    val clickableSpan = object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsDetail?.url))
                            startActivity(intent)
                        }
                    }

                    spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    binding.newsUrl.text = spannableString
                    binding.newsUrl.movementMethod = LinkMovementMethod.getInstance()
                    binding.newsPoster.load(newsDetail?.poster){
                        placeholder(R.drawable.ic_launcher_foreground)
                        fallback(R.drawable.breaking_news)
                    }
                }
            }

        }
    }
}