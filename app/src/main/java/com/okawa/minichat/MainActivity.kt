package com.okawa.minichat

import com.okawa.minichat.base.BaseActivity
import com.okawa.minichat.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>() {

    override fun layoutToInflate() = R.layout.main_activity

    override fun containerId() = R.id.container

}
