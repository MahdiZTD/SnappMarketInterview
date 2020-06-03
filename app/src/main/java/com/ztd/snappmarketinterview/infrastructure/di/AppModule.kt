package com.ztd.snappmarketinterview.infrastructure.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ztd.snappmarketinterview.infrastructure.data.DataManager
import com.ztd.snappmarketinterview.infrastructure.data.DataManagerImp
import com.ztd.snappmarketinterview.infrastructure.data.local.db.AppDatabase
import com.ztd.snappmarketinterview.infrastructure.data.local.db.DatabaseHelper
import com.ztd.snappmarketinterview.infrastructure.data.local.db.DatabaseHelperImp
import com.ztd.snappmarketinterview.infrastructure.data.local.preference.PreferenceHelper
import com.ztd.snappmarketinterview.infrastructure.data.local.preference.PreferenceHelperImp
import com.ztd.snappmarketinterview.infrastructure.data.remote.ApiHelper
import com.ztd.snappmarketinterview.infrastructure.data.remote.ApiHelperImp
import com.ztd.snappmarketinterview.infrastructure.utils.AppSchedulerProvider
import com.ztd.snappmarketinterview.infrastructure.utils.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideParser(): Gson {
        return GsonBuilder().create()
    }


    @Provides
    fun provideSchedulerProvider(): SchedulersProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideDataManager(dataManagerImp: DataManagerImp): DataManager {
        return dataManagerImp
    }

    @Provides
    @Singleton
    fun provideDbHelper(databaseHelperImp: DatabaseHelperImp): DatabaseHelper {
        return databaseHelperImp
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(preferenceHelperImp: PreferenceHelperImp): PreferenceHelper {
        return preferenceHelperImp
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "INTERVIEW_DATABASE")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(): ApiHelper {
        return ApiHelperImp()
    }
}