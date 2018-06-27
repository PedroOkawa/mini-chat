package com.okawa.minichat.di.component

import com.google.gson.Gson
import com.okawa.minichat.App
import com.okawa.minichat.api.ApiManager
import com.okawa.minichat.api.ApiService
import com.okawa.minichat.di.module.AppModule
import com.okawa.minichat.di.module.ApiModule
import com.okawa.minichat.di.module.UtilsModule
import dagger.Component
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ ApiModule::class, AppModule::class, UtilsModule::class ])
interface AppComponent {

    /* APP */
    fun inject(app: App)
    fun provideApp() : App

    /* API */
    fun provideLoggingInterceptor() : HttpLoggingInterceptor
    fun provideGson() : Gson
    fun provideOkHttpClient() : OkHttpClient
    fun provideRetrofit() : Retrofit
    fun provideApiService() : ApiService

    /* UTILS */
    fun provideApiManager() : ApiManager

}