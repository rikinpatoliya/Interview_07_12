package com.example.myapplication.presentation.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.presentation.components.AppScaffold
import com.example.myapplication.presentation.components.button.SubmitButton
import com.example.myapplication.presentation.components.inputField.AppOutlinedTextField
import com.example.myapplication.presentation.components.loading.AppLoading
import com.example.myapplication.presentation.components.preview.MyAppPreview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.example.myapplication.presentation.components.space.Height
import com.example.myapplication.presentation.screen.destinations.DashboardScreenDestination
import com.example.myapplication.presentation.theme.gilroyFont
import com.example.myapplication.utils.UiState
import com.example.myapplication.utils.toast
import com.versionx.valetease.utils.ext.collectState

@Preview
@Composable
fun PreviewDashboardScreen() {
    MyAppPreview {
        LoginContent(
            mobileNo = "",
            onMobileNoChange = {},
            isLoggedIn = true,
            isLoading = false,
            onMobileNoErrorMsg = "Error",
            isError = false,
            onLoginClick = {
            }
        )
        /*DashboardContent(
            onProfileClick = {
            },
            onNotificationClick = {},
            vehicleRequestOnClick = {},
            vehicleDetailOnClick = {},
            raiseTicketOnClick = {},
            unConfirmedOnClick = {},
        )*/

    }
}
@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    loginViewModel: LoginViewModel = hiltViewModel(),
){
    val state by loginViewModel.collectState()
    val ctx = LocalContext.current

    AppScaffold {
        LoginContent(
            mobileNo = state.userName,
            onMobileNoChange = loginViewModel::setMobileNo,
            isLoggedIn = state.loginUiState != UiState.Loading,
            isLoading = state.loginUiState == UiState.Loading,
            onMobileNoErrorMsg =  "",
            isError = false,
            onLoginClick = {
                if (state.userName.isNotEmpty()){

                navigator.navigate(DashboardScreenDestination(userName = state.userName))
                }else{
                    ctx.toast("Please enter valid user name or email id")
                }
//                            navigator.navigate(VerifyOtpScreenDestination("9999999999"))
//                if (state.isMobileNoValidate) {
//                    loginViewModel.login(ctx, navigator)
//                } else {
//                    ctx.toast("Please enter valid mobile number")
//                }
            }
        )
    }
}


@Composable
fun LoginContent(
    mobileNo: String,
    onMobileNoErrorMsg: String,
    onMobileNoChange: (String) -> Unit,
    isLoading: Boolean,
    isError: Boolean,
    isLoggedIn: Boolean,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 70.dp, bottom = 15.dp)
            .fillMaxSize(),
    ) {
        GreetingLogin()
        48.Height()
        LoginForm(
            mobileNo = mobileNo,
            onMobileNoErrorMsg = onMobileNoErrorMsg,
            onMobileNoChange = onMobileNoChange,
            isLoading = isLoading,
            isError = isError,
            isLoggedIn = isLoggedIn,
            onLoginClick = onLoginClick,
        )

    }
}

@Composable
fun LoginForm(
    mobileNo: String,
    onMobileNoErrorMsg: String,
    onMobileNoChange: (String) -> Unit,
    isLoading: Boolean,
    isError: Boolean,
    isLoggedIn: Boolean,
    onLoginClick: () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    Column{
        AppOutlinedTextField(
            label = "User Name / Email Id",
            hintText = "ex. aaa@gmail.com",
            value = mobileNo,
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }),
            enabled = !isLoading,
            isError = isError,
            onValueChange = onMobileNoChange,
            errorMessage = onMobileNoErrorMsg,
//                        isError = state.isValidMobileNo,
        )
        Spacer(modifier = Modifier.weight(1.0f))
//        TermCondition()
        20.Height()
        if (isLoading) {
            AppLoading(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            SubmitButton(
                text = "Login",
                enabled = isLoggedIn,
                onClick = onLoginClick,
            )
        }
    }
}

@Composable
fun GreetingLogin() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff212529),
                    fontSize = 24.sp
                )
            ) { append("Welcome,\n") }
            withStyle(
                style = SpanStyle(
                    fontFamily = gilroyFont,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xff212529),
                    fontSize = 24.sp
                )
            ) { append("Glad to see you") }
        },
    )
}
