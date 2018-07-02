package com.okawa.minichat.utils

import android.view.View

interface TouchListener {

    fun onTouch(view: View?, position: Int?)
    fun onLongTouch(view: View?, position: Int?)

}