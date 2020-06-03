package com.ztd.snappmarketinterview.infrastructure.data

import androidx.lifecycle.LiveData
import com.ztd.snappmarketinterview.infrastructure.data.local.db.DatabaseHelper
import com.ztd.snappmarketinterview.infrastructure.data.local.preference.PreferenceHelper
import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsHeadlineResponse
import com.ztd.snappmarketinterview.infrastructure.data.model.api.NewsSourceResponse
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity
import com.ztd.snappmarketinterview.infrastructure.data.remote.ApiHelper
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */

interface DataManager : DatabaseHelper, ApiHelper, PreferenceHelper {
}

class DataManagerImp @Inject constructor(
    private val databaseHelper: DatabaseHelper,
    private val apiHelper: ApiHelper,
    private val preferenceHelper: PreferenceHelper
) : DataManager {

    override fun saveAllNewsArticle(articles: MutableList<ArticleEntity>): Completable =
        databaseHelper.saveAllNewsArticle(articles)

    override fun saveAllNewsSources(sources: MutableList<SourceEntity>): Completable =
        databaseHelper.saveAllNewsSources(sources)

    override fun getAllNewsSources(): LiveData<MutableList<SourceEntity>>? =
        databaseHelper.getAllNewsSources()

    override fun getAllNewsArticleBySource(sourceId: String): LiveData<MutableList<ArticleEntity>>? =
        databaseHelper.getAllNewsArticleBySource(sourceId)

    //--

    override fun getNewsSources(apiKey: String): Single<NewsSourceResponse> =
        apiHelper.getNewsSources(apiKey)

    override fun getNewsHeadlines(apiKey: String, sourceId: String): Single<NewsHeadlineResponse> =
        apiHelper.getNewsHeadlines(apiKey, sourceId)

}