package com.okawa.minichat.ui.chat

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseFragment
import com.okawa.minichat.data.Result
import com.okawa.minichat.data.Status
import com.okawa.minichat.databinding.FragmentChatBinding
import com.okawa.minichat.db.relation.FullMessage
import com.okawa.minichat.ui.confirmation.ConfirmationDialog
import com.okawa.minichat.utils.ConversationAdapter
import com.okawa.minichat.utils.OnConversationItemTouchListener
import com.okawa.minichat.utils.TouchListener
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
        dataBinding.rclChatContent.addOnItemTouchListener(OnConversationItemTouchListener(context, dataBinding.rclChatContent, object : TouchListener {

            override fun onTouch(view: View?, position: Int?) {

            }

            override fun onLongTouch(view: View?, position: Int?) {
                val item = adapter.retrieveItem(position?:return)
                val dialog = ConfirmationDialog.newInstance(item?.message?.messageId ?: return)
                dialog.show(fragmentManager, "fragment_confirmation")
                //viewModel.deleteMessage(item?.message?.messageId)
            }

        }))
    }

    private fun retrieveData() {
        viewModel.retrieveConversation().observe(this, Observer { result ->
            handleState(result ?: return@Observer)
        })
    }

    private fun handleState(result: Result<PagedList<FullMessage>>) {
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
