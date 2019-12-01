package dev.pinaki.mealdecider.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import dev.pinaki.mealdecider.R
import dev.pinaki.mealdecider.util.anim.BounceAnimationInterpolator

fun View.bounce(onAnimationEnd: ((View) -> Unit)? = null) {
    val animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
    animation.interpolator = BounceAnimationInterpolator(0.2, 40.0)

    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {
            if (onAnimationEnd != null)
                onAnimationEnd(this@bounce)
        }

        override fun onAnimationStart(animation: Animation?) {

        }

    })
    startAnimation(animation)
}

fun View.centre() = Pair((x + width / 2), (y + height / 2))