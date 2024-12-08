package com.example.myapplication.presentation.screen.dashboard

import com.example.myapplication.data.db.entities.MedicationEntity
import com.example.myapplication.data.models.response.MedicineResponse
import com.example.myapplication.utils.UiState
import com.versionx.valetease.presentation.screen.base.State

data class DashboardState(
    val medicineUiState: UiState<List<MedicationEntity>> = UiState.Idle
//    val mobileNo: TextFieldValue = TextFieldValue(),
//    val isMobileNoValidate: Boolean = false,
//    val loginUiState: UiState<Any?> = UiState.Idle,
//    val isShowFirstLogoutDialog: Boolean= false,
//    val isShowSecondLogoutDialog: Boolean= false

) : State
