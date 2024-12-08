package com.example.myapplication.presentation.screen.login

import com.example.myapplication.utils.UiState
import com.versionx.valetease.presentation.screen.base.State

data class LoginState(
    val userName: String = "",
    val loginUiState: UiState<Any> = UiState.Idle
    ) : State
