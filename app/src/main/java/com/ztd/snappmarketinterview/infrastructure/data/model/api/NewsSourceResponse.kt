package com.ztd.snappmarketinterview.infrastructure.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
data class NewsSourceResponse(
    @SerializedName("status")
    @Expose
    val status : String,
    @SerializedName("sources")
    @Expose
    val sources: MutableList<SourceEntity>
)