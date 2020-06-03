package com.ztd.snappmarketinterview.infrastructure.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @SerializedName("author")
    @Expose
    @ColumnInfo(name = "author")
    val author: String?,
    @SerializedName("content")
    @Expose
    @ColumnInfo(name = "content")
    val content: String?,
    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    val description: String?,
    @SerializedName("publishedAt")
    @Expose
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String?,
    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    val title: String?,
    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "url")
    val url: String?,
    @SerializedName("urlToImage")
    @Expose
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?,
    @ColumnInfo(name = "source_id")
    val sourceId: String?
)