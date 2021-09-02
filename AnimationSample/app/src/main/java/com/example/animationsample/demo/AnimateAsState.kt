package com.example.animationsample.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp


@Composable
internal fun AnimateAsStateDemo() {
    var colorState by remember { mutableStateOf(true) }
    val selectColor by animateColorAsState(targetValue = if (colorState) Color.Blue else Color.Green)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { colorState = !colorState }
        ) {
            Text(text = "CHANGE COLOR")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = selectColor)
        )
    }
}

@Composable
internal fun AnimateAsStateDemo2() {
    var alphaState by remember { mutableStateOf(true) }
    val selectAlphaValue by animateFloatAsState(targetValue = if (alphaState) 1.0f else 0.5f)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { alphaState = !alphaState }
        ) {
            Text(text = "CHANGE ALPHA VALUE")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(alpha = selectAlphaValue)
                .background(color = Color.Red)
        )
    }
}