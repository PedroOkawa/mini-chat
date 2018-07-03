package com.okawa.minichat

import com.okawa.minichat.di.component.DaggerAppTestComponent
import dagger.android.support.DaggerApplication

class AppTest : DaggerApplication() {

    val appComponent = DaggerAppTestComponent.builder().application(this).build()

    override fun applicationInjector() = appComponent

}