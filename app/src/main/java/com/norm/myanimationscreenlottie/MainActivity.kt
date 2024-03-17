package com.norm.myanimationscreenlottie

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.norm.myanimationscreenlottie.ui.theme.MyAnimationScreenLottieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )
        setContent {
            MyAnimationScreenLottieTheme {
                MainScreen()
            }
        }
    }
}