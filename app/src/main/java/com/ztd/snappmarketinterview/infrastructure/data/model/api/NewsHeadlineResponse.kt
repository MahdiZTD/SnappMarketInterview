package com.ztd.snappmarketinterview.infrastructure.data.model.api


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity

data class NewsHeadlineResponse(
    @SerializedName("articles")
    @Expose
    val articles: MutableList<ArticleResponse>,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("totalResults")
    @Expose
    val totalResults: Int
)