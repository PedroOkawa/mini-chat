package com.okawa.minichat.di

import com.okawa.minichat.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun provideApp() = app

}