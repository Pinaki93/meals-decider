package dev.pinaki.mealdecider.ui.activities

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.pinaki.mealdecider.R
import dev.pinaki.mealdecider.util.bounce
import dev.pinaki.mealdecider.util.centre
import kotlinx.android.synthetic.main.layout_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)

        tv_meal_chooser.setOnClickListener {
            meal_chooser_container.bounce(onAnimationEnd = {
                //                performExitAnimation()
                startActivity(Intent(this, MealDeciderActivity::class.java))
            })
        }
    }

    private fun performExitAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val endRadius = Math.max(root_layout.width, root_layout.height)
            val (centerX, centerY) = meal_chooser_container.centre()

            val duration = 1000

            val circularReveal = ViewAnimationUtils.createCircularReveal(
                root_layout,
                centerX.toInt(),
                centerY.toInt(),
                0F,
                endRadius.toFloat()
            ).setDuration(duration.toLong())


            startColorAnimation(
                root_layout,
                ContextCompat.getColor(this, R.color.persian_orange),
                ContextCompat.getColor(this, R.color.bg_color),
                duration
            )
            circularReveal.start()
        }
    }

    private fun startColorAnimation(view: View, startColor: Int, endColor: Int, duration: Int) {
        val anim = ValueAnimator()
        anim.setIntValues(startColor, endColor)
        anim.setEvaluator(ArgbEvaluator())
        anim.addUpdateListener { valueAnimator -> view.setBackgroundColor(valueAnimator.animatedValue as Int) }
        anim.duration = duration.toLong()
        anim.start()
    }
}
