package com.versionx.valetease.presentation.components.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.myapplication.presentation.components.button.SubmitButton
import com.example.myapplication.presentation.components.preview.MyAppPreview
import com.example.myapplication.presentation.theme.*
import com.example.myapplication.presentation.theme.gilroyFont
import com.example.myapplication.presentation.components.space.Height

@Preview
@Composable
fun PreviewNoDataFoundWidget() {
    MyAppPreview  {
        NoDataFoundWidget(
            text = "No Data Found!",
            onRetry = {

            }
        )
    }
}

@Composable
fun NoDataFoundWidget(
    text: String? = "Something Went Wrong!",
    mainTextColor: Color = color212529,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text ?: "Something Went Wrong!",
            color = mainTextColor,
            lineHeight = 1.em,
            fontFamily = gilroyFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        if (onRetry != null) {
            10.Height()
            SubmitButton(
                modifier = Modifier.size(140.dp, 48.dp),
                onClick = onRetry,
                text = "Try Again"
            )
        }

    }
}