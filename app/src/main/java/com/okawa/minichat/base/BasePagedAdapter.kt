package com.okawa.minichat.base

import android.arch.paging.PagedListAdapter
import android.support.annotation.LayoutRes
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BasePagedAdapter<T>(diffCallBack: DiffUtil.ItemCallback<T>) :  PagedListAdapter<T, RecyclerView.ViewHolder>(diffCallBack) {

    @LayoutRes abstract fun layoutToInflate(viewType: Int): Int

    abstract fun defineViewHolder(viewType: Int, view: View) : RecyclerView.ViewHolder

    abstract fun doOnBindViewHolder(holder: RecyclerView.ViewHolder, item: T?, position: Int)

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutToInflate(viewType), parent, false)
        return defineViewHolder(viewType, view)
    }

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        doOnBindViewHolder(holder, getItem(position), position)
    }

}