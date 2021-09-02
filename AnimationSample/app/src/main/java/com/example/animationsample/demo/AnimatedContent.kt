package com.example.animationsample.demo

import android.util.Log
import android.widget.Space
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Use AnimatedContent + customize transitionSpec
@ExperimentalAnimationApi
@Composable
fun AnimatedContentDemo() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                Log.d(
                    "AnimatedContentDemo",
                    "targetState : $targetState initialState $initialState"
                )
                if (targetState > initialState) {
                    // case: count up
                    slideInVertically({ height -> height }) + fadeIn() with
                            slideOutVertically({ height -> -height }) + fadeOut()
                } else {
                    // case: count down
                    slideInVertically({ height -> -height }) + fadeIn() with
                            slideOutVertically({ height -> height }) + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(text = "$targetCount")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row() {
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Count Up")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { count-- },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Count Down")
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}