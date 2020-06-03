package com.ztd.snappmarketinterview.infrastructure.data.local.db

import androidx.lifecycle.LiveData
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi Zare Tahghigh Doost on 5/10/2020.
 *
 * mahdiZTD@gmail.com
 */

interface DatabaseHelper {
    fun saveAllNewsArticle(articles: MutableList<ArticleEntity>): Completable
    fun saveAllNewsSources(sources: MutableList<SourceEntity>): Completable

    fun getAllNewsSources(): LiveData<MutableList<SourceEntity>>?
    fun getAllNewsArticleBySource(sourceId: String): LiveData<MutableList<ArticleEntity>>?
}

@Singleton
class DatabaseHelperImp @Inject constructor(val appDatabase: AppDatabase) : DatabaseHelper {
    override fun saveAllNewsArticle(articles: MutableList<ArticleEntity>) =
        Completable.create {
            appDatabase.articleDao()?.saveAll(articles)
            it.onComplete()
        }

    override fun saveAllNewsSources(sources: MutableList<SourceEntity>) =
        Completable.create {
            appDatabase.sourceDao()?.saveAll(sources)
            it.onComplete()
        }

    override fun getAllNewsSources(): LiveData<MutableList<SourceEntity>>? =
        appDatabase.sourceDao()?.loadAll()

    override fun getAllNewsArticleBySource(sourceId: String): LiveData<MutableList<ArticleEntity>>? =
        appDatabase.articleDao()?.loadAllBySource(sourceId)


}