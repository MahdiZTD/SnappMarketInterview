package com.ztd.snappmarketinterview.infrastructure.di

import android.app.Application
import com.ztd.snappmarketinterview.InterviewApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton



@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class , AppModule::class, ContributorModule::class))
interface AppComponent {
    fun inject(app: InterviewApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }
}