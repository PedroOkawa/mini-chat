package com.okawa.minichat.di.module

import com.okawa.minichat.api.ApiManager
import com.okawa.minichat.api.ApiService
import dagger.Module
import dagger.Provides

@Module(includes = [ RepositoryModule::class, UseCaseModule::class ])
class UtilsModule {

    @Provides
    fun provideApiManager(apiService: ApiService) = ApiManager(apiService)

}