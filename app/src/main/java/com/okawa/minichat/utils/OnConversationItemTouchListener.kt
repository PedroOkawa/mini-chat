package com.okawa.minichat.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

open class OnConversationItemTouchListener(context: Context?, recyclerView: RecyclerView?, val touchListener: TouchListener?) : RecyclerView.OnItemTouchListener {

    var gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapUp(e: MotionEvent?) = true

            override fun onLongPress(e: MotionEvent?) {
                val view = recyclerView?.findChildViewUnder(e?.x ?: 0F, e?.y ?: 0F)
                touchListener?.onLongTouch(view, recyclerView?.getChildAdapterPosition(view))
            }
        })
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {

    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        val view = rv?.findChildViewUnder(e?.x ?: 0F, e?.y ?: 0F)

        if(view != null && touchListener != null && gestureDetector.onTouchEvent(e)) {
            touchListener.onTouch(view, rv.getChildAdapterPosition(view))
        }

        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}