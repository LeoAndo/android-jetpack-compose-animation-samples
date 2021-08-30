package com.example.animationsample.demo

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationsample.R

@Composable
internal fun AnimateContentSizeDemo() {
    var expanded by remember { mutableStateOf(true) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { expanded = !expanded }
        ) {
            Text(text = if (expanded) "SHRINK" else "EXPAND")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Red)
                .animateContentSize()
        ) {
            Text(
                text = stringResource(id = R.string.message),
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp),
                maxLines = if (expanded) Int.MAX_VALUE else 1
            )
        }
    }
}