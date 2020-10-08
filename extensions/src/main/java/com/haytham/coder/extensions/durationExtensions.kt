package com.haytham.coder.extensions

import android.os.CountDownTimer
import org.threeten.bp.Duration

/**
 * nice to use timer
 */
fun Duration.startCountDown(
    onFinished: (() -> Unit)? = null,
    onTicked: ((remainingDuration: Duration) -> Unit)? = null,
    intervalInMilli:Long?=null
): CountDownTimer = object : CountDownTimer(toMillis(), intervalInMilli?:toMillis()) {
    override fun onTick(millisUntilFinished: Long) {
        onTicked?.invoke(Duration.ofMillis(millisUntilFinished))
    }

    override fun onFinish() {
        onFinished?.invoke()
    }

}.start()