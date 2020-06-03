package com.ztd.snappmarketinterview.infrastructure.data.remote

import android.content.Context
import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsHeadlineResponse
import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsSourceResponse
import com.ztd.snappmarketinterview.infrastructure.network.RetrofitInterface
import com.ztd.snappmarketinterview.infrastructure.network.RetrofitUtils
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

interface ApiHelper {

    fun getNewsSources(apiKey: String): Single<NewsSourceResponse>
    fun getNewsHeadlines(apiKey: String, sourceId: String): Single<NewsHeadlineResponse>
}

@Singleton
class ApiHelperImp : ApiHelper {

    override fun getNewsSources(apiKey: String): Single<NewsSourceResponse> =
        RetrofitUtils()
            .getRetrofit()
            .create(RetrofitInterface::class.java)
            .getNewsSources(apiKey)

    override fun getNewsHeadlines(apiKey: String, sourceId: String): Single<NewsHeadlineResponse> =
        RetrofitUtils()
            .getRetrofit()
            .create(RetrofitInterface::class.java)
            .getHeadlinesBySources(apiKey, sourceId)

}