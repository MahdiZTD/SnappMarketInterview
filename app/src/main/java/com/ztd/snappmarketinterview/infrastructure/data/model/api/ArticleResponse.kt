package com.ztd.snappmarketinterview.infrastructure.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity

data class ArticleResponse(
    @SerializedName("author")
    @Expose
    val author: String,
    @SerializedName("content")
    @Expose
    val content: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("publishedAt")
    @Expose
    val publishedAt: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String,
    @SerializedName("source")
    @Expose
    val source: SourceEntity
)