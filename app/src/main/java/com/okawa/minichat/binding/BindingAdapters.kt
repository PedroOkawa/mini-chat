package com.okawa.minichat.binding

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:hide")
    fun hide(view: View, hide: Boolean) {
        view.visibility = if(hide) View.GONE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:placeholder", "bind:image"])
    fun image(imageView: ImageView, placeholder: Drawable?, image: String?) {
        Glide.with(imageView.context)
                .load(image?:return)
                .apply(RequestOptions().placeholder(placeholder).dontAnimate())
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("circleImage")
    fun circleImage(imageView: ImageView, path: String?) {
        Glide.with(imageView.context)
                .load(path?:return)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
    }

}