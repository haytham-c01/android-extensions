package com.haytham.coder.extensions

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Point
import android.net.Uri
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity

/**
 * get the selectableItemBackgroundBorderless background resource value
 */
val Context.selectableItemBackgroundBorderless: Int
    get() {
        val outValue = TypedValue()
        theme.resolveAttribute(
            android.R.attr.selectableItemBackgroundBorderless,
            outValue,
            true
        )
        return outValue.resourceId
    }

/**
 * get AppCompatActivity from context
 */
val Context.activity: AppCompatActivity?
    get() {
        var context = this
        while (context is ContextWrapper) {
            if (context is AppCompatActivity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }

/**
 * get screen size
 */
val Context.screenSize
    get() = Point().apply {
        (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(this)
    }

/**
 * load animation resource
 */
fun Context.loadAnimation(@AnimRes animationRes: Int): Animation = AnimationUtils.loadAnimation(this, animationRes)

/**
 * show toast
 */
fun Context.showToast(msg: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, msg, length).show()
}

/**
 * get layoutInflater from context
 */
val Context.layoutInflater: LayoutInflater get() = LayoutInflater.from(this)

/**
 * open keyboard
 */
fun Context.openKeyboard() {
    val imm: InputMethodManager? =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

/**
 * launch pdf viewer app chooser through intent
 */
fun Context.openPdfViewer(url:String){
    val pdfIntent = Intent(Intent.ACTION_VIEW)
    pdfIntent.setDataAndType(Uri.parse(url) , "application/pdf")
    startActivity(pdfIntent)
}