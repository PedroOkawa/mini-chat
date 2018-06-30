package com.okawa.minichat.binding

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("hide")
    fun hide(view: View, hide: Boolean) {
        view.visibility = if(hide) View.GONE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("image")
    fun image(imageView: ImageView, path: String) {
        Glide.with(imageView.context)
                .load(path)
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("circleImage")
    fun circleImage(imageView: ImageView, path: String) {
        Glide.with(imageView.context)
                .load(path)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
    }

}