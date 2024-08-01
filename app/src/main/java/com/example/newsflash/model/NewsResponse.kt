package com.example.newsflash.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class NewsResponse(
    val status : String,
    val totalResults : Int,
    val articles : List<NewsArticle>
)

@Parcelize
data class NewsArticle (
    val title : String?,
    val url : String ?,
    val author : String,
    @SerializedName("urlToImage") val poster: String?,
    val description : String?,
    @SerializedName("publishedAt") val date : String?
): Parcelable
