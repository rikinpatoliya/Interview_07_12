package com.example.myapplication.presentation.screen.login

import com.versionx.valetease.presentation.screen.base.State

data class LoginState(
    val mobileNo: TextFieldValue = TextFieldValue(),
    val password: TextFieldValue = TextFieldValue(),

) : State
