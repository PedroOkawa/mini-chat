package com.okawa.minichat.di.module

import android.app.Application
import com.google.gson.Gson
import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.utils.FileHelper
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module(includes = [ RepositoryModule::class ])
class UtilsTestModule {

    @Singleton
    @Provides
    fun provideApiManager(): ApiManager {
        return mock(ApiManager::class.java)
    }

    @Singleton
    @Provides
    fun provideFileHelper(app: Application, gson: Gson) = FileHelper(app, gson)

}