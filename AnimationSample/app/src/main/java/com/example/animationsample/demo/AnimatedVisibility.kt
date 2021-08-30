package com.example.animationsample.demo

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
internal fun AnimatedVisibilityDemo() {
    var visible by remember { mutableStateOf(true) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = visible, enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(color = Color.Red)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { visible = !visible }
        ) {
            Text(text = if (visible) "VISIBLE" else "GONE")
        }
    }
}