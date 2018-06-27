package com.okawa.minichat.di

import com.okawa.minichat.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ AppModule::class ])
interface AppComponent {

    /* APP */
    fun inject(app: App)
    fun provideApp(): App



}