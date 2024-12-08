package com.example.myapplication.presentation.screen.login

import com.versionx.valetease.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : BaseViewModel<LoginState>(initialState = LoginState()) {

}