package com.haytham.coder.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.BidiFormatter
import android.util.Base64
import java.nio.charset.StandardCharsets

fun String.decodeTokenBody(): String {
    val splitString = this.split('.')
//    val base64EncodedHeader = splitString[0]
    val base64EncodedBody = splitString[1]
//    val base64EncodedSignature = splitString[2]
    return base64EncodedBody.base64Decode()
}

/**
 * decode string with base64
 */
fun String.base64Decode(): String {
    val bytes: ByteArray = Base64.decode(this, Base64.URL_SAFE)
    return String(bytes, StandardCharsets.UTF_8)
}

/**
 * launch url through browser
 */
fun String.openUrl(context: Context) {
    val url =
        if (!startsWith("http://") && !startsWith("https://"))
            "http://$this"
        else this

    val uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}

/**
 * format string to fix bidirectional text issue
 */
fun String.unicodeWrap(): String = BidiFormatter.getInstance().unicodeWrap(this)
fun String?.isNotNullOrBlank ()= !isNullOrBlank()

/**
 * replace arabic numbers in strings with english numbers
 */
fun String.replaceArNumbersWithEn() = this
    .replace('٠', '0')
    .replace('١', '1')
    .replace('٢', '2')
    .replace('٣', '3')
    .replace('٤', '4')
    .replace('٥', '5')
    .replace('٦', '6')
    .replace('٧', '7')
    .replace('٨', '8')
    .replace('٩', '9')