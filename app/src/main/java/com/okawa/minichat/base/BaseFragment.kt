package com.okawa.minichat.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.okawa.minichat.di.component.AppComponent


abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    protected lateinit var viewModel: VM
    protected lateinit var dataBinding: T

    @LayoutRes
    abstract fun layoutToInflate(): Int

    abstract fun defineViewModel() : VM

    abstract fun inject(appComponent: AppComponent)

    abstract fun doOnCreated()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = defineDataBinding(inflater, container)
        viewModel = defineViewModel()
        inject(getApp().appComponent)
        doOnCreated()
        return view
    }

    private fun defineDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        dataBinding = DataBindingUtil.inflate(inflater, layoutToInflate(), container, false)
        return dataBinding.root
    }

    fun getBaseActivity() = activity as BaseActivity<*>

    fun getApp() = getBaseActivity().getApp()

}