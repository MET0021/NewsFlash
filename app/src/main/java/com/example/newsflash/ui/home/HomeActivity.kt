package com.example.newsflash.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsflash.R
import com.example.newsflash.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity(){

    private val TAG = HomeActivity::class.java.simpleName
    private lateinit var binding: HomeActivityBinding
    private lateinit var homeFragment: HomeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeFragment = supportFragmentManager.findFragmentById(R.id.home_news_fragment) as HomeFragment
    }
}