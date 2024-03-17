package com.norm.myanimationscreenlottie

import android.support.v4.os.IResultReceiver2.Default
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.norm.myanimationscreenlottie.ui.theme.MyGreen
import com.norm.myanimationscreenlottie.ui.theme.MyOrange

@Composable
fun MainScreen() {
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background))
    val progress by animateLottieCompositionAsState(
        composition = composition.value,
        iterations = LottieConstants.IterateForever
    )

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = MyGreen,
        targetValue = MyOrange,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ), label = ""
    )

    LottieAnimation(
        modifier = Modifier.fillMaxSize(),
        composition = composition.value,
        progress = { progress }
    )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 80.dp)
                .padding(horizontal = 40.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                fontWeight = FontWeight.Bold,
                lineHeight = MaterialTheme.typography.displayLarge.lineHeight,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = stringResource(id = R.string.description),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )
            Button(
                onClick = { },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = color),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text(
                    text = "Place your first order!",
                    color = Color.Black
                )
            }
        }
    }
}