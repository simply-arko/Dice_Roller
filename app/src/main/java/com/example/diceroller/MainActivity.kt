package com.example.diceroller

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animator: Animator) {
            }

            override fun onAnimationEnd(animator: Animator) {
                hideDice()
                val randomNumber = (1..6).random()
                textView.text = "$randomNumber"
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })

    }

    private fun showDice(){
        dice.visibility = View.VISIBLE
        textView.visibility = View.GONE
        button.isEnabled = false
    }

    private fun hideDice() {
        dice.visibility = View.GONE
        textView.visibility = View.VISIBLE
        button.isEnabled = true
    }

    fun rollDice(view: View) {
        showDice()
        dice.playAnimation()
    }
}