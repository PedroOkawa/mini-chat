package com.okawa.minichat

import com.okawa.minichat.di.component.DaggerAppComponent
import dagger.android.support.DaggerApplication

open class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()

}