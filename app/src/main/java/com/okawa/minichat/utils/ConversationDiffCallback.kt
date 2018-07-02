package com.okawa.minichat.utils

import android.support.v7.util.DiffUtil
import com.okawa.minichat.db.relation.FullMessage

class ConversationDiffCallback : DiffUtil.ItemCallback<FullMessage>() {

    override fun areItemsTheSame(oldItem: FullMessage?, newItem: FullMessage?) = oldItem?.message?.id == newItem?.message?.id

    override fun areContentsTheSame(oldItem: FullMessage?, newItem: FullMessage?) = oldItem?.equals(newItem) ?: false

}