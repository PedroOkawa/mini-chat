package com.okawa.minichat.utils

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.okawa.minichat.R
import com.okawa.minichat.base.BasePagedAdapter
import com.okawa.minichat.databinding.AdapterMessageMeBinding
import com.okawa.minichat.databinding.AdapterMessageOthersBinding
import com.okawa.minichat.db.relation.FullMessage

class ConversationAdapter : BasePagedAdapter<FullMessage>(diffCallback) {

    companion object {
        const val USER_ME_ID: Long = 1
        const val MESSAGE_ME = 0x00
        const val MESSAGE_OTHERS = 0x01

        val diffCallback =  ConversationDiffCallback()
    }

    override fun defineViewHolder(viewType: Int, view: View) = when(viewType) {
        MESSAGE_ME -> MeViewHolder(view)
        else -> OthersViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position)?.user?.id == USER_ME_ID) MESSAGE_ME else MESSAGE_OTHERS
    }

    override fun layoutToInflate(viewType: Int) = when(viewType) {
        MESSAGE_ME -> R.layout.adapter_message_me
        else -> R.layout.adapter_message_others
    }

    override fun doOnBindViewHolder(holder: RecyclerView.ViewHolder, item: FullMessage?, position: Int) {
        when(holder) {
            is MeViewHolder -> {
                holder.dataBinding.message = item?.message?.content
            }
            is OthersViewHolder -> {
                holder.dataBinding.avatarUrl = item?.user?.avatarId
                holder.dataBinding.username = item?.user?.name
                holder.dataBinding.message = item?.message?.content
            }
        }
    }

    class MeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterMessageMeBinding = DataBindingUtil.bind(view)!!

    }

    class OthersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dataBinding: AdapterMessageOthersBinding = DataBindingUtil.bind(view)!!

    }

}