package com.okawa.minichat.di.module

import com.okawa.minichat.ui.chat.ChatFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeChatFragment(): ChatFragment

}