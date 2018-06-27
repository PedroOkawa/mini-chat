package com.okawa.minichat.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.okawa.minichat.R
import com.okawa.minichat.base.BaseFragment
import com.okawa.minichat.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun layoutToInflate() = R.layout.main_fragment

    override fun retrieveViewModel(viewModelFactory: ViewModelProvider.Factory) =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

    override fun doOnCreated() {

    }

}
