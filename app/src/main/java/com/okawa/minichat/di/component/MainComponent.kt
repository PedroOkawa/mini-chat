package com.okawa.minichat.di.component

import com.okawa.minichat.ui.main.MainActivity
import com.okawa.minichat.di.module.MainModule
import com.okawa.minichat.di.scope.Activity
import dagger.Component

@Activity
@Component(dependencies = [ AppComponent::class ], modules = [ MainModule::class ])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

}