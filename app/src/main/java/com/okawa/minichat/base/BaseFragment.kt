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
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM
    protected lateinit var dataBinding: T

    @LayoutRes
    abstract fun layoutToInflate(): Int

    abstract fun retrieveViewModel(viewModelFactory: ViewModelProvider.Factory) : VM

    abstract fun doOnCreated()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = defineDataBinding(inflater, container)
        defineViewModel()
        doOnCreated()
        return view
    }

    private fun defineDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        dataBinding = DataBindingUtil.inflate(inflater, layoutToInflate(), container, false)
        return dataBinding.root
    }

    private fun defineViewModel() {
        viewModel = retrieveViewModel(viewModelFactory)
    }

}