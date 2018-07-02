package com.okawa.minichat.ui.chat

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseFragment
import com.okawa.minichat.data.Result
import com.okawa.minichat.data.Status
import com.okawa.minichat.databinding.FragmentChatBinding
import com.okawa.minichat.db.relation.FullMessageEntity
import com.okawa.minichat.utils.ConversationAdapter
import javax.inject.Inject

class ChatFragment : BaseFragment<FragmentChatBinding, ChatViewModel>() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val adapter = ConversationAdapter()

    override fun defineViewModel(): ChatViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ChatViewModel::class.java)

    override fun layoutToInflate() = R.layout.fragment_chat

    override fun doOnCreated() {
        initRecyclerView()
        retrieveData()
    }

    private fun initRecyclerView() {
        dataBinding.rclChatContent.adapter = adapter
        dataBinding.rclChatContent.layoutManager = LinearLayoutManager(context)
    }

    private fun retrieveData() {
        viewModel.retrieveConversation().observe(this, Observer { result ->
            handleState(result ?: return@Observer)
        })
    }

    private fun handleState(result: Result<PagedList<FullMessageEntity>>) {
        dataBinding.loading = result.status == Status.LOADING

        when(result.status) {
            Status.SUCCESS -> {
                adapter.submitList(result.data?:return)
            }
            Status.ERROR -> {
                Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
            }
            else -> {

            }
        }
    }

}
