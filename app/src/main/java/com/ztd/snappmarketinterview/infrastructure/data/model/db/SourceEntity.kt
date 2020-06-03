package com.ztd.snappmarketinterview.infrastructure.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
@Entity(tableName = "source")
data class SourceEntity(
    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @SerializedName("category")
    @Expose
    @ColumnInfo(name = "category")
    val category: String?,
    @SerializedName("country")
    @Expose
    @ColumnInfo(name = "country")
    val country: String?,
    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    val description: String?,
    @SerializedName("language")
    @Expose
    @ColumnInfo(name = "language")
    val language: String?,
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    val name: String?,
    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "url")
    val url: String?
)