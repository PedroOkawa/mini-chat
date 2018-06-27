package com.okawa.minichat.di.component

import com.okawa.minichat.di.module.ChatModule
import com.okawa.minichat.di.scope.Fragment
import com.okawa.minichat.ui.chat.ChatFragment
import dagger.Component

@Fragment
@Component(dependencies = [ AppComponent::class ], modules = [ ChatModule::class ])
interface ChatComponent {

    fun inject(chatFragment: ChatFragment)

}