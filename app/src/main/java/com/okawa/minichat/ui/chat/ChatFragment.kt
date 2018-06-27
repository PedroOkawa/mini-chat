package com.okawa.minichat.ui.chat

import androidx.lifecycle.ViewModelProviders
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseFragment
import com.okawa.minichat.databinding.FragmentChatBinding
import com.okawa.minichat.di.component.AppComponent
import com.okawa.minichat.di.component.DaggerChatComponent

class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    override fun defineViewModel(): ChatViewModel =
            ViewModelProviders.of(this).get(ChatViewModel::class.java)

    override fun inject(appComponent: AppComponent) {
        DaggerChatComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this)
    }

    override fun layoutToInflate() = R.layout.fragment_chat

    override fun doOnCreated() {

    }

}
