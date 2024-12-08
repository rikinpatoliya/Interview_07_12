package com.example.myapplication.presentation.screen.login

import androidx.lifecycle.viewModelScope
import com.example.myapplication.utils.UiState
import com.versionx.valetease.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : BaseViewModel<LoginState>(initialState = LoginState()) {
    fun setMobileNo(userName: String) {
        setState { state ->
            state.copy(userName = userName)
        }
    }

    fun login() {
        setState { state -> state.copy(loginUiState = UiState.Loading) }
        viewModelScope.launch {
            delay(10000)
        setState { state -> state.copy(loginUiState = UiState.Success("")) }
        }

    }
}