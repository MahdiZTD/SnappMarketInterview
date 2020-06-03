package com.ztd.snappmarketinterview.mvvm.articlefragment

import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import com.ztd.snappmarketinterview.mvvm.articlefragment.adapter.NewsArticleAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */

@Module
class ArticleModule {

    @Provides
    fun provideViewModel(
        dataManager: DataManager,
        schedulersProvider: SchedulersProvider
    ): ArticleViewModel = ArticleViewModel(dataManager, schedulersProvider)


    @Provides
    fun provideArticleAdapter(): NewsArticleAdapter = NewsArticleAdapter(mutableListOf())
}