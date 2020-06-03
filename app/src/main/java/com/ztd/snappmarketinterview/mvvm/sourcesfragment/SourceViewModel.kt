package com.ztd.snappmarketinterview.mvvm.sourcesfragment

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity
import com.ztd.snappmarketinterview.infrastructure.utils.Constants
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import com.ztd.snappmarketinterview.mvvm.base.BaseViewModel

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class SourceViewModel(
    private val dataManager: DataManager,
    private val schedulersProvider: SchedulersProvider
) : BaseViewModel<SourceNavigator>(dataManager, schedulersProvider) {

    val sources = ObservableArrayList<SourceEntity>()
    val sourceLiveData = MutableLiveData<MutableList<SourceEntity>>()


    fun apiGetNewsHeadlines() {
        compositeDisposable.add(
            dataManager.getNewsSources(Constants.API_KEY)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe(
                    {
                        sourceLiveData.value = it.sources
                    },
                    {
                        it.printStackTrace()
                    }
                )
        )
    }

    fun databaseSaveSources(sources: MutableList<SourceEntity>) {
        compositeDisposable.add(
            dataManager.saveAllNewsSources(sources)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe()
        )
    }

    fun databaseFetchNewsSources(): LiveData<MutableList<SourceEntity>>? =
        dataManager.getAllNewsSources()


}