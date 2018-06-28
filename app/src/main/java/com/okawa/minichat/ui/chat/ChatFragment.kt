package com.okawa.minichat.ui.chat

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseFragment
import com.okawa.minichat.databinding.FragmentChatBinding
import javax.inject.Inject

class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun defineViewModel(): ChatViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ChatViewModel::class.java)

    override fun layoutToInflate() = R.layout.fragment_chat

    override fun doOnCreated() {
        viewModel.retrieveConversation()
    }

}
