package com.okawa.minichat.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    companion object {
        const val DEFAULT_CONTAINER_ID = 0
    }

    protected lateinit var dataBinding: T

    @LayoutRes
    abstract fun layoutToInflate(): Int

    @IdRes
    open fun containerId() = DEFAULT_CONTAINER_ID

    open fun initialFragment(): Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        defineDataBinding()

        if (savedInstanceState == null) {
            defineInitialFragment()
        }
    }

    private fun defineDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutToInflate())
    }

    private fun defineInitialFragment() {
        val initialFragment = initialFragment() ?: return

        if (containerId() != DEFAULT_CONTAINER_ID) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(containerId(), initialFragment)
                    .commitNow()
        }
    }

}