package com.example.animationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.animationsample.demo.*
import com.example.animationsample.ui.theme.AnimationSampleTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,) {
                    // AnimateAsStateDemo()
                    AnimateAsStateDemo2()
                    // UpdateTransitionDemo()
                    // AnimatedVisibilityDemo()
                    //AnimatedVisibilityDemo2()
                    // AnimateContentSizeDemo()
                    // CrossFadeDemo()
                    // AnimatedContentDemo()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimationSampleTheme {
        Greeting("Android")
    }
}