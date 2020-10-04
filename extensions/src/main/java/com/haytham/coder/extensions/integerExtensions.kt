package com.haytham.coder.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Int.toColor(context: Context) = ContextCompat.getColor(context, this)
fun Int.toColorStateList(context: Context) = ContextCompat.getColorStateList(context, this)

fun Int.toDimen(context: Context) = context.resources.getDimension(this)

fun Int.toDrawable(context: Context): Drawable? =
    ResourcesCompat.getDrawable(context.resources, this, null)
fun Int.toString(context: Context,vararg args: Any) = context.resources.getString(this, *args)

fun Int.pxToDp(): Int {
    val px= this
    return (px / Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.dpToPx(): Int {
    val dp= this
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}

/**
 * validate an integer to be:
 *
 * 1- not null
 *
 * 2- more than > -1
 *
 * 3- less than < size
 *
 */
fun Int?.isValidIndex (size:Int= Integer.MAX_VALUE)= this!=null && this > -1 && this < size

