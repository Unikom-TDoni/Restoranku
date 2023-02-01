package edu.unikom.restoranku.core

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import edu.unikom.restoranku.R

class MainActivity : AppCompatActivity() {

    private var isScreenReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplashScreen()
        startSplashScreenTimer()
        setContentView(R.layout.activity_main)
    }

    private fun startSplashScreenTimer() {
        val timer = object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                isScreenReady = true
            }
        }
        timer.start()
    }

    private fun initSplashScreen() =
        installSplashScreen().apply { setKeepOnScreenCondition { !isScreenReady } }
}