@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.presentation.components.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.presentation.theme.*

@Preview
@Composable
fun TestAppBar() {
    AppBar(
        title = "Vehicle",
        titleSub = "Details",
        titleContentColor = colorFFFFFF,
        backgroundColor = color000000

    )
}

@Composable
fun AppBar(
    title: String? = null,
    titleSub: String? = null,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    backgroundColor: Color = colorE9ECEF,
    titleContentColor: Color = color212529,
) {

    CenterAlignedTopAppBar(
        title =
        {
            if (title != null) {
                Text(
                    textAlign = TextAlign.Center,
                    lineHeight = 1.sp,
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 18.sp,
                                fontFamily = gilroyFont,
                                fontWeight = FontWeight.Bold
                            )
                        ) { append(title) }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 18.sp,
                                fontFamily = gilroyFont,
                            )
                        ) { append(" $titleSub") }
                    },
                )
            }
        },
        modifier = modifier,
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = titleContentColor
        ),
        navigationIcon = navigationIcon,
    )
}