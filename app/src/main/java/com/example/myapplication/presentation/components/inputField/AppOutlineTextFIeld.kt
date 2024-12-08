@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.presentation.components.inputField


import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.myapplication.presentation.theme.*
import com.versionx.valetease.presentation.components.space.Height


@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    hintText: String,
    label: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    errorIcon: @Composable (() -> Unit)? = null,
    errorMessage: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.colors(

//        textColor = MyColors.color606060,
        unfocusedIndicatorColor = colorDEE2E6,
        unfocusedContainerColor = Color.White,
        focusedIndicatorColor = color00A1E2,
        focusedContainerColor = Color.White,
        errorContainerColor = Color.White,
//        containerColor = if (enabled) MyColors.colorFFFFFF else MyColors.colorE3E6E6,
//        disabledTextColor = Color.Transparent,
//        focusedIndicatorColor = MyColors.colorE3E6E6,
//        unfocusedIndicatorColor = MyColors.colorE3E6E6,
//        disabledIndicatorColor = MyColors.colorE3E6E6
    )
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label, style = TextStyle(
                fontSize = 14.sp,
                fontFamily = gilroyFont,
                color = colorADB5BD,
                fontWeight = FontWeight.W500,
            )
        )
        10.Height()
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = gilroyFont,
                color = color212529,
                fontWeight = FontWeight.W700,
                letterSpacing = 1.05.sp,
            ),
            placeholder = {
                Text(
                    text = hintText,
                    color = colorADB5BD,
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 1.em,
                    fontSize = 16.sp
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = if (isError) errorIcon else trailingIcon,
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            minLines = minLines,
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors
        )
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 12.dp)
        ) {
            CompositionLocalProvider(
                LocalTextStyle provides LocalTextStyle.current.copy(
                    fontSize = 12.sp,
                    color = if (isError) MaterialTheme.colorScheme.error else LocalTextStyle.current.color
                )
            ) {
                if (isError) {
                    if (errorMessage != null) {
//                        errorMessage()

                        Text(
                            text = errorMessage,
                            fontSize = 12.sp,
                            fontFamily = gilroyFont,
                            color = MaterialTheme.colorScheme.error,
                            fontWeight = FontWeight.SemiBold,
                        )

                    }
                } else {
                    /*if (helperMessage != null) {
                        CompositionLocalProvider(
                            LocalContentAlpha provides ContentAlpha.medium
                        ) {
                            helperMessage()
                        }
                    }*/
                }
            }
        }
    }
}

@Preview(name = "Normal", showBackground = true, device = "id:pixel_5")
@Composable
fun OutlinedTextFieldDayHelperPreview() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        AppOutlinedTextField(
            hintText = "Mobile Number",
            value = "8511770120",
            onValueChange = { },
            enabled = true,
            label = "Mobile Number",
            errorMessage = "Please enter number"
            /*  trailingIcon = {
                  Icon(
                      painter = rememberVectorPainter(image = Icons.Rounded.AccountCircle),
                      contentDescription = null
                  )
              },
              errorIcon = {
                  Icon(
                      painter = rememberVectorPainter(image = Icons.Rounded.Add),
                      contentDescription = null
                  )
              },*/

        )


    }
}

@Preview(name = "Day ꞏ Error", showBackground = true)
@Composable
fun OutlinedTextFieldNightHelperPreview() {

    Surface(modifier = Modifier.padding(15.dp)) {
        AppOutlinedTextField(
            hintText = "Mobile Number",
            value = "",
            onValueChange = { },
            errorMessage = "This is an error!",
            errorIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Rounded.Add),
                    contentDescription = null
                )
            },
            label = "Mobile Number",
            isError = true
        )
    }
}