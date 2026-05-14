package com.example.virasatnamma.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.virasatnamma.R
import com.example.virasatnamma.databinding.ActivitySplashBinding
import com.example.virasatnamma.utils.LocaleHelper

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        LocaleHelper.applyAppLanguage(this)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.logoImage.startAnimation(fadeIn)
        binding.titleText.startAnimation(fadeIn)
        binding.subtitleText.startAnimation(fadeIn)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
