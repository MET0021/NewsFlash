package com.example.newsflash.ui.newsDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NewsDetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, NewsDetailsFragment.newInstance())
            .commit()
    }
}