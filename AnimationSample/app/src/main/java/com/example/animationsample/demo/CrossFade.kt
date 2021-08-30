package com.example.animationsample.demo

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationsample.R

private enum class Scene {
    Text,
    Icon
}

@Composable
internal fun CrossFadeDemo() {
    var scene by remember { mutableStateOf(Scene.Text) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                scene = when (scene) {
                    Scene.Text -> Scene.Icon
                    Scene.Icon -> Scene.Text
                }
            }
        ) {
            Text(text = "TOGGLE")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Crossfade(targetState = scene) { scene ->
            when (scene) {
                Scene.Text -> {
                    Text(text = "Phone")
                }
                Scene.Icon -> {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.Phone),
                        contentDescription = "Phone",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}