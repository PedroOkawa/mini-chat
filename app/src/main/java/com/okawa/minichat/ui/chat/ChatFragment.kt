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
import android.content.Intent
import android.net.Uri


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
        dataBinding.rclChatContent.addOnItemTouchListener(OnConversationItemTouchListener(context,
                dataBinding.rclChatContent,
                object: TouchListener {

                    override fun onTouch(view: View?, position: Int?) {
                        val item = adapter.retrieveItem(position?:return)
                        showAttachment(item)
                    }

                    override fun onLongTouch(view: View?, position: Int?) {
                        val item = adapter.retrieveItem(position?:return)
                        showConfirmationDialog(item)
                    }

                }
        ))
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

    private fun showConfirmationDialog(message: FullMessage?) {
        val dialog = ConfirmationDialog.newInstance(message?.message?.messageId ?: return)
        dialog.show(fragmentManager, ConfirmationDialog.DIALOG_TAG)
    }

    private fun showAttachment(message: FullMessage?) {
        if(message?.message?.isAttachment == true) {
            val intent = Intent()

            val uri = Uri.parse(message.message?.url)
            intent.data = uri
            intent.action = android.content.Intent.ACTION_VIEW

            if(intent.resolveActivity(context?.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(context,
                        "Impossible to handle the action",
                        Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }

}
