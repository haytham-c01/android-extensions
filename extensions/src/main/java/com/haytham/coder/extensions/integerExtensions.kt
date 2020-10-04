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

/**
 * it gets a valid phone number as entered by the user, and convert it to the complete form
 * COMPLETE PHONE FORM: +964##########, 10 hashes
 * @receiver a valid phone number must be passed!!, This function doesn't validate the phone
 *
 * below all possible cases of conversion:
 * - (10 chars)1234567899 -> +9641234567899 (append +964)
 * - (11 chars)01234567899 -> +9641234567899 (append +964 && remove first 0)
 * - (13 chars)9641234567899 -> +9641234567899 (append +)
 * - (14 chars)+9641234567899 -> +9641234567899 (do nothing)
 * - (15 chars)009641234567899 -> +9641234567899 (append + && remove 00)
 * - phone with other length -> same as input(do nothing)
 * @return if input phone length is not invalid -> same as input, else -> complete phone number
 */

fun String.toCompleteIQPhone(): String {
    return when (length) {
        10 -> "+964$this"
        11 -> "+964" + substring(1)
        13 -> "+$this"
        14 -> this
        15 -> "+" + substring(2)
        else -> this
    }
}