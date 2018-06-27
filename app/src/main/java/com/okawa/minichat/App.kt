package com.okawa.minichat

import android.app.Application
import com.okawa.minichat.di.component.AppComponent
import com.okawa.minichat.di.module.AppModule
import com.okawa.minichat.di.component.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

}