package com.haytham.coder.extensions

import android.graphics.Color
import android.util.LayoutDirection
import android.view.View
import android.view.ViewTreeObserver
import com.google.android.material.snackbar.Snackbar

val View.isRtl get() = layoutDirection == View.LAYOUT_DIRECTION_RTL

/**
 * change view Visibility to GONE or INVISIBLE
 */
fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE else View.INVISIBLE
}

/**
 * change view Visibility to VISIBLE
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * do something after layout is drawn
 */
fun View.afterLayoutDrawn(action: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(
        object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (measuredWidth > 0 && measuredHeight > 0) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this)
                    action()
                }
            }
        }
    )
}

/**
 *  listen to visibility change
 */
fun View.setOnVisibilityChangedListener(onVisibilityChanged: (View) -> Unit){
    var prevVisibility = visibility
    viewTreeObserver.addOnGlobalLayoutListener {
        if (prevVisibility != visibility) {
            prevVisibility = visibility
            onVisibilityChanged(this)
        }
    }
}