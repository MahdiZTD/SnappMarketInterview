package com.ztd.snappmarketinterview.mvvm.sourcesfragment

import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import com.ztd.snappmarketinterview.mvvm.sourcesfragment.adapter.NewsSourceAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */

@Module
class SourceModule {

    @Provides
    fun provideViewModel(
        dataManager: DataManager,
        schedulersProvider: SchedulersProvider
    ): SourceViewModel = SourceViewModel(dataManager, schedulersProvider)

    @Provides
    fun provideSourceAdapter(): NewsSourceAdapter = NewsSourceAdapter(mutableListOf())
}