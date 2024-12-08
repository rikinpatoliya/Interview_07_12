package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.presentation.theme.colorFFFFFF


@Preview
@Composable
fun PreviewScaffoldPreview() {
    AppScaffold{
        Text("Hello")
    }
}


@Composable
fun AppScaffold(
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color? = null,
    content: @Composable () -> Unit = {},
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
//        content = content,
        containerColor = containerColor ?: colorFFFFFF,
    )
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}