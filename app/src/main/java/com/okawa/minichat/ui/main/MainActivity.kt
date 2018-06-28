package com.okawa.minichat.ui.main

import com.okawa.minichat.R
import com.okawa.minichat.base.BaseActivity
import com.okawa.minichat.databinding.ActivityMainBinding
import com.okawa.minichat.ui.chat.ChatFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initialFragment() = ChatFragment.newInstance()

    override fun layoutToInflate() = R.layout.activity_main

    override fun containerId() = R.id.container

}
