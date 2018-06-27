package com.okawa.minichat.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.okawa.minichat.App
import com.okawa.minichat.di.component.AppComponent

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

    abstract fun inject(appComponent: AppComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        defineDataBinding()
        inject(getApp().appComponent)

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

    fun getApp() = application as App

}