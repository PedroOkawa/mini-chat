package com.okawa.minichat.di.component

import android.app.Application
import com.okawa.minichat.App
import com.okawa.minichat.di.module.*
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
    UtilsModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)

}