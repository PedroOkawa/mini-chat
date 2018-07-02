package com.okawa.minichat.di.module

import com.okawa.minichat.ui.confirmation.ConfirmationDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeConfirmationDialog(): ConfirmationDialog

}