package com.okawa.minichat.utils

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.okawa.minichat.R
import com.okawa.minichat.base.BasePagedAdapter
import com.okawa.minichat.databinding.AdapterAttachmentMeBinding
import com.okawa.minichat.databinding.AdapterAttachmentOthersBinding
import com.okawa.minichat.databinding.AdapterMessageMeBinding
import com.okawa.minichat.databinding.AdapterMessageOthersBinding
import com.okawa.minichat.db.relation.FullMessageEntity

class ConversationAdapter : BasePagedAdapter<FullMessageEntity>(diffCallback) {

    companion object {
        const val USER_ME_ID: Long = 1
        const val MESSAGE_ME = 0x00
        const val MESSAGE_OTHERS = 0x01
        const val ATTACHMENT_ME = 0x02
        const val ATTACHMENT_OTHERS = 0x03

        val diffCallback =  ConversationDiffCallback()
    }

    override fun defineViewHolder(viewType: Int, view: View) = when(viewType) {
        MESSAGE_ME -> MeMessageViewHolder(view)
        ATTACHMENT_ME -> MeAttachmentViewHolder(view)
        MESSAGE_OTHERS -> OthersMessageViewHolder(view)
        else -> OthersAttachmentViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return if(item?.user?.id == USER_ME_ID) {
            if(item.message?.isAttachment == true) ATTACHMENT_ME else MESSAGE_ME
        } else  {
            if(item?.message?.isAttachment == true) ATTACHMENT_OTHERS else MESSAGE_OTHERS
        }
    }

    override fun layoutToInflate(viewType: Int) = when(viewType) {
        MESSAGE_ME -> R.layout.adapter_message_me
        ATTACHMENT_ME -> R.layout.adapter_attachment_me
        MESSAGE_OTHERS -> R.layout.adapter_message_others
        else -> R.layout.adapter_attachment_others
    }

    override fun doOnBindViewHolder(holder: RecyclerView.ViewHolder, item: FullMessageEntity?, position: Int) {
        when(holder) {
            is MeMessageViewHolder -> {
                holder.dataBinding.message = item?.message?.content
            }
            is MeAttachmentViewHolder -> {
                holder.dataBinding.image = item?.message?.thumbnailUrl
                holder.dataBinding.title = item?.message?.title
            }
            is OthersMessageViewHolder -> {
                holder.dataBinding.avatarUrl = item?.user?.avatarId
                holder.dataBinding.username = item?.user?.name
                holder.dataBinding.message = item?.message?.content
            }
            is OthersAttachmentViewHolder -> {
                holder.dataBinding.image = item?.message?.thumbnailUrl
                holder.dataBinding.title = item?.message?.title
            }
        }
    }

    class MeMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterMessageMeBinding = DataBindingUtil.bind(view)!!

    }

    class OthersMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterMessageOthersBinding = DataBindingUtil.bind(view)!!

    }

    class MeAttachmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterAttachmentMeBinding = DataBindingUtil.bind(view)!!

    }

    class OthersAttachmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterAttachmentOthersBinding = DataBindingUtil.bind(view)!!

    }

}