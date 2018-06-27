package com.okawa.minichat.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

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
        if (containerId() != DEFAULT_CONTAINER_ID && initialFragment() != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(containerId(), initialFragment()!!)
                    .commitNow()
        }
    }

}