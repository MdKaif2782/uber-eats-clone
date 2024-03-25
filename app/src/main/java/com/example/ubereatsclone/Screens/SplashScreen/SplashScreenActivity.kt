package com.example.ubereatsclone.Screens.SplashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults.ProgressAnimationSpec
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ubereatsclone.MainActivity
import com.example.ubereatsclone.R
import com.example.ubereatsclone.ui.theme.UberEatsCloneTheme
import kotlinx.coroutines.delay

val TAG:String = SplashScreenActivity::class.java.simpleName
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UberEatsCloneTheme {
                SplashScreen()
            }
        }
    }

    @SuppressLint("NotConstructor")
    @Composable
    private fun SplashScreen(){
        val progressAnimationSpec = remember { ProgressAnimationSpec() }

        LaunchedEffect(Unit) {
            progressAnimationSpec.animateProgressTo(1f)
            if (progressAnimationSpec.currentProgress() == 1f) {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }
        }

        Log.d(TAG, "SplashScreen: progress: ${progressAnimationSpec.currentProgress()}")



        Box(modifier = Modifier
            .fillMaxSize(1f)
            .background(color = Color(0xff06c067))
            ) {
            LinearProgressIndicator(progress = progressAnimationSpec.currentProgress(),
                color=Color.White, trackColor = Color.Transparent, modifier = Modifier.fillMaxWidth(),
            )
            Image(painter = painterResource(id = R.drawable.ubereats),
                contentDescription = "logo",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SplashScreenPreview() {
        SplashScreen()
    }
}


private class ProgressAnimationSpec {
    private val progress = Animatable(0f)

    init {
        progress.updateBounds(0f, 1f)
    }

    suspend fun animateProgressTo(toValue: Float) {
        progress.animateTo(
            targetValue = toValue,
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
        )
    }

    fun currentProgress(): Float = progress.value
}


