package com.ztd.snappmarketinterview.mvvm.base

import androidx.lifecycle.ViewModel
import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */

abstract class BaseViewModel<N>(dataManager: DataManager, schedulersProvider: SchedulersProvider) : ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var mNavigator: WeakReference<N>

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}