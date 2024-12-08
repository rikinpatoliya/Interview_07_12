package com.example.myapplication.presentation.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.versionx.valetease.presentation.theme.color00A1E2
import com.versionx.valetease.presentation.theme.colorADB5BD
import com.example.myapplication.presentation.theme.gilroyFont

@Preview
@Composable
fun PreviewBtn() {
    SubmitButton(
        onClick = {},
        enabled = false,
        text = "Log In"
    )
}

@Composable
fun SubmitButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    backgroundColor: Color = color00A1E2,
    modifier: Modifier = Modifier,
) {

    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = colorADB5BD
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = gilroyFont,
                color = Color.White,
                fontWeight = FontWeight.W700,
            )
        )
    }
}