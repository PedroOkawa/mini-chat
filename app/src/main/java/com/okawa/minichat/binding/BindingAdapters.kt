package com.okawa.minichat.binding

import android.databinding.BindingAdapter
import android.view.View

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("hide")
    fun hide(view: View, hide: Boolean) {
        view.visibility = if(hide) View.GONE else View.VISIBLE
    }

}