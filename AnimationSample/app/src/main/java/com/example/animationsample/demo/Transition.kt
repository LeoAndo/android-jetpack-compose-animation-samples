package com.example.animationsample.demo

import androidx.compose.animation.animateColor
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
import androidx.compose.ui.unit.dp

private enum class BoxState {
    Small,
    Medium,
    Large,
}

private fun findByOrdinal(ordinal: Int): BoxState {
    return BoxState.values().first { it.ordinal == ordinal }
}

@Composable
internal fun UpdateTransitionDemo() {
    var boxState by remember { mutableStateOf(BoxState.Small) }
    val transition = updateTransition(targetState = boxState, label = "")
    val selectColor by transition.animateColor(label = "", transitionSpec = {
        if (this.targetState == BoxState.Large) tween(1000) else spring()
    }) { state ->
        when (state) {
            BoxState.Small -> Color.Red
            BoxState.Medium -> Color.Blue
            BoxState.Large -> Color.Yellow
        }
    }
    val selectSize by transition.animateDp(label = "", transitionSpec = {
        if (this.targetState == BoxState.Large) tween(1000) else spring()
    }) { state ->
        when (state) {
            BoxState.Small -> 50.dp
            BoxState.Medium -> 100.dp
            BoxState.Large -> 200.dp
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { boxState = findByOrdinal((boxState.ordinal + 1) % BoxState.values().size) }
        ) {
            Text(text = "CHANGE COLOR AND SIZE")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(selectSize)
                .background(color = selectColor)
        )
    }
}