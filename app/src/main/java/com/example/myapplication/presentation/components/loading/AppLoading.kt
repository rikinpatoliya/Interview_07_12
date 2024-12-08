package com.example.myapplication.presentation.components.loading

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.theme.color000000

@Preview
@Composable
fun AppLoadingCompPreview() {
    AppLoading()
}

@Composable
fun AppLoading(
    modifier: Modifier = Modifier,
    color: Color = color000000,
    strokeWidth: Dp = 4.dp,
) {
    CircularProgressIndicator(
        color = color,
        modifier = modifier
            .size(40.dp),
        strokeWidth = strokeWidth,
    )
}