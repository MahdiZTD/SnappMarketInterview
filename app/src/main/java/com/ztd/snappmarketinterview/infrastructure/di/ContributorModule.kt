package com.ztd.snappmarketinterview.infrastructure.di

import com.ztd.snappmarketinterview.mvvm.articlefragment.ArticleFragment
import com.ztd.snappmarketinterview.mvvm.articlefragment.ArticleModule
import com.ztd.snappmarketinterview.mvvm.mainactivity.MainActivity
import com.ztd.snappmarketinterview.mvvm.sourcesfragment.SourceFragment
import com.ztd.snappmarketinterview.mvvm.sourcesfragment.SourceModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ContributorModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [SourceModule::class])
    abstract fun bindSourceFragment(): SourceFragment

    @ContributesAndroidInjector(modules = [ArticleModule::class])
    abstract fun bindArticleFragment(): ArticleFragment

}