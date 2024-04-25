package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LinhaDivider(
    color: Color = Color.Black,
    thickness: Dp = 10.dp,
    modifier: Modifier
) {
    Canvas(modifier = modifier.height(thickness)) {
        drawLine(
            color = color,
            start = Offset(1f, 1f),
            end = Offset(size.width, 1f),
            strokeWidth = thickness.toPx(),
        )
    }
}