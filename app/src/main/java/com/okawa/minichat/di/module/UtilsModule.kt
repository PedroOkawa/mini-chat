package com.okawa.minichat.di.module

import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.api.service.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ RepositoryModule::class ])
class UtilsModule {

    @Singleton
    @Provides
    fun provideApiManager(apiService: ApiService) = ApiManager(apiService)

}