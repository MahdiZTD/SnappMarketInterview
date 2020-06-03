package com.ztd.snappmarketinterview.mvvm.articlefragment

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.data.model.api.ArticleResponse
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.utils.Constants
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import com.ztd.snappmarketinterview.mvvm.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class ArticleViewModel(
    private val dataManager: DataManager,
    private val schedulersProvider: SchedulersProvider
) : BaseViewModel<ArticleNavigator>(dataManager, schedulersProvider) {

    val articles = ObservableArrayList<ArticleEntity>()
    val articleLiveData = MutableLiveData<MutableList<ArticleResponse>>()

    fun apiGetNewsArticleBySource(sourceId: String) {
        compositeDisposable.add(
            dataManager.getNewsHeadlines(Constants.API_KEY, sourceId)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(
                    {
                        articleLiveData.value = it.articles
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }

    fun databaseSaveArticles(articles:MutableList<ArticleEntity>){
        compositeDisposable.add(
            dataManager.saveAllNewsArticle(articles)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe()
        )
    }

    fun databaseFetchNewsArticle(sourceId: String):LiveData<MutableList<ArticleEntity>>? =
        dataManager.getAllNewsArticleBySource(sourceId)

}