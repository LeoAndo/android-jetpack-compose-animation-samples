package com.example.animationsample.demo

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

// Use AnimatedVisibility + MutableTransitionState
@ExperimentalAnimationApi
@Composable
internal fun AnimatedVisibilityDemo2() {
    val state = remember { MutableTransitionState(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visibleState = state, enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(color = Color.Red)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { state.targetState = !state.targetState }) {
            Text(
                text = when {
                    state.isIdle && state.currentState -> "Visible"
                    !state.isIdle && state.currentState -> "Disappearing"
                    state.isIdle && !state.currentState -> "Invisible"
                    else -> "Appearing"
                }
            )
        }
    }
}