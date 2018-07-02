package com.okawa.minichat.utils

import android.support.v7.util.DiffUtil
import com.okawa.minichat.db.relation.FullMessageEntity

class ConversationDiffCallback : DiffUtil.ItemCallback<FullMessageEntity>() {

    override fun areItemsTheSame(oldItem: FullMessageEntity?, newItem: FullMessageEntity?) = oldItem?.message?.id == newItem?.message?.id

    override fun areContentsTheSame(oldItem: FullMessageEntity?, newItem: FullMessageEntity?) = oldItem?.equals(newItem) ?: false

}