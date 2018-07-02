package com.okawa.minichat.binding

import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.okawa.minichat.R

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:hide")
    fun hide(view: View, hide: Boolean) {
        view.visibility = if(hide) View.GONE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("bind:image")
    fun image(imageView: ImageView, image: String) {
        Glide.with(imageView.context)
                .load(image)
                .apply(RequestOptions().dontAnimate())
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