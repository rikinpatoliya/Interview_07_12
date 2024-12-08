package com.example.myapplication.presentation.screen.medicineDetail

import androidx.compose.ui.text.input.TextFieldValue
import com.versionx.valetease.presentation.screen.base.State

data class MedicineState(
    val mobileNo: TextFieldValue = TextFieldValue(),
    val password: TextFieldValue = TextFieldValue(),

    ) : State
