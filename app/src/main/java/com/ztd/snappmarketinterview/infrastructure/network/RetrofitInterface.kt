package com.ztd.snappmarketinterview.infrastructure.network

import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsHeadlineResponse
import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsSourceResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("/v2/sources?language=en")
    fun getNewsSources(@Query("apiKey") apiKey: String): Single<NewsSourceResponse>

    @GET("/v2/top-headlines")
    fun getHeadlinesBySources(@Query("apiKey") apiKey: String, @Query("sources") sources: String): Single<NewsHeadlineResponse>

}
