package com.okawa.minichat.di.component

import android.app.Application
import com.okawa.minichat.AppTest
import com.okawa.minichat.di.module.*
import com.okawa.minichat.suite.ChatFragmentTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBuildersModule::class,
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    AppModule::class,
    DatabaseModule::class,
    UtilsTestModule::class
])
interface AppTestComponent : AndroidInjector<AppTest> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppTestComponent
    }

    override fun inject(appTest: AppTest)

    fun inject(chatFragmentTest: ChatFragmentTest)

}