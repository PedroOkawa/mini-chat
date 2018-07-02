package com.okawa.minichat.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import dagger.android.support.DaggerAppCompatDialogFragment

abstract class BaseDialog<T : ViewDataBinding, VM : ViewModel> : DaggerAppCompatDialogFragment() {

    protected lateinit var viewModel: VM
    protected lateinit var dataBinding: T

    @LayoutRes
    abstract fun layoutToInflate(): Int

    abstract fun defineViewModel() : VM

    abstract fun doOnCreated()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = defineViewModel()
        doOnCreated()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            defineDataBinding(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_NoTitleBar)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun defineDataBinding(layoutInflater: LayoutInflater, container: ViewGroup?): View {
        dataBinding = DataBindingUtil.inflate(layoutInflater, layoutToInflate(), container, false)
        return dataBinding.root
    }

}