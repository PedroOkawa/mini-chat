package com.okawa.minichat.utils

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.okawa.minichat.R
import com.okawa.minichat.base.BasePagedAdapter
import com.okawa.minichat.databinding.AdapterAttachmentBinding
import com.okawa.minichat.databinding.AdapterMessageMeBinding
import com.okawa.minichat.databinding.AdapterMessageOthersBinding
import com.okawa.minichat.db.relation.FullMessage

class ConversationAdapter : BasePagedAdapter<FullMessage>(diffCallback) {

    companion object {
        const val USER_ME_ID: Long = 1
        const val MESSAGE_ME = 0x00
        const val MESSAGE_OTHERS = 0x01
        const val ATTACHMENT = 0x02

        val diffCallback =  ConversationDiffCallback()
    }

    override fun defineViewHolder(viewType: Int, view: View) = when(viewType) {
        MESSAGE_ME -> MeMessageViewHolder(view)
        MESSAGE_OTHERS -> OthersMessageViewHolder(view)
        else -> MeAttachmentViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return if(item?.user?.id == USER_ME_ID) {
            if(item.message?.isAttachment == true) ATTACHMENT else MESSAGE_ME
        } else  {
            if(item?.message?.isAttachment == true) ATTACHMENT else MESSAGE_OTHERS
        }
    }

    override fun layoutToInflate(viewType: Int) = when(viewType) {
        MESSAGE_ME -> R.layout.adapter_message_me
        MESSAGE_OTHERS -> R.layout.adapter_message_others
        else -> R.layout.adapter_attachment
    }

    override fun doOnBindViewHolder(holder: RecyclerView.ViewHolder, item: FullMessage?, position: Int) {
        when(holder) {
            is MeMessageViewHolder -> {
                holder.setup(item)
            }
            is OthersMessageViewHolder -> {
                holder.setup(item)
            }
            is MeAttachmentViewHolder -> {
                holder.setup(item)
            }
        }
    }

    class MeMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var dataBinding: AdapterMessageMeBinding = DataBindingUtil.bind(view)!!

        fun setup(item: FullMessage?) {
            dataBinding.message = item?.message?.content
        }

    }

    class MeAttachmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var dataBinding: AdapterAttachmentBinding = DataBindingUtil.bind(view)!!

        fun setup(item: FullMessage?) {
            dataBinding.isMine = item?.user?.id == USER_ME_ID
            dataBinding.image = item?.message?.thumbnailUrl
            dataBinding.title = item?.message?.title
        }

    }

    class OthersMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var dataBinding: AdapterMessageOthersBinding = DataBindingUtil.bind(view)!!

        fun setup(item: FullMessage?) {
            dataBinding.avatarUrl = item?.user?.avatarId
            dataBinding.username = item?.user?.name
            dataBinding.message = item?.message?.content
        }

    }

}