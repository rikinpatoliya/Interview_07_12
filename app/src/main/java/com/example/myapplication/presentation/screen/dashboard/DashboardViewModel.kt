package com.example.myapplication.presentation.screen.dashboard

import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repositories.MedicationRepository
import com.example.myapplication.utils.UiState
import com.versionx.valetease.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val medicationRepository: MedicationRepository
) : BaseViewModel<DashboardState>(initialState = DashboardState()) {

    @SuppressLint("NewApi")
    fun getTimeOfDayGreeting(): String {
        val hour = LocalTime.now().hour
        return when (hour) {
            in 5..11 -> "Morning"
            in 12..16 -> "Afternoon"
            else -> "Evening"
        }
    }

    fun getMedicineList() {
        setState { state -> state.copy(medicineUiState = UiState.Loading) }
        viewModelScope.launch {
            try {
                val medicationList = medicationRepository.fetchMedications()
                if (medicationList.isNotEmpty()) {
                    setState { state -> state.copy(medicineUiState = UiState.Success(medicationList)) }
                } else {
                    setState { state -> state.copy(medicineUiState = UiState.Empty) }

                }
            } catch (e: IOException) {
                setState { state -> state.copy(medicineUiState = UiState.Error("Network error. Please try again later.")) }
            } catch (e: Exception) {
                setState { state -> state.copy(medicineUiState = UiState.Error("An unexpected error occurred: ${e.message}")) }
            }

        }
    }

}