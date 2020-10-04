package com.haytham.coder.extensions

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * change stats bar color to White, and the icons + text to black
 * if we try to change status bar color, it won't work until this view is disappeared
 */
fun Activity.setStatusBarColorToWhite(chainedWith: View) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.WHITE

        var flags = chainedWith.systemUiVisibility
        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        chainedWith.systemUiVisibility = flags
    }
}

fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = color
    }
}

fun Activity.setSoftInputMode(softInputMode: Int) {
    window.setSoftInputMode(softInputMode)
}



/**
 * go into full screen mode by hiding the system ui
 */
fun Activity.hideSystemUi() {
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN)
}