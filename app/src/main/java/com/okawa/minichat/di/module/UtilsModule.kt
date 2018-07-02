package com.okawa.minichat.di.module

import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.api.service.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ RepositoryModule::class ])
class UtilsModule {

    @Provides
    fun provideApiManager(apiService: ApiService) = ApiManager(apiService)

}