package com.example.myapplication.presentation.screen.medicineDetail

import com.versionx.valetease.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MedicineDetailModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel<DashboardState>(initialState = DashboardState()) {

    init {

//        Timber.d(getCurrentDate(DATE_YYYY_MM_DD_HH_MM_SS))
    }
//    fun showFirstLogoutDialog(isDialogOpen: Boolean) {
//        setState {state->
//            state.copy(isShowFirstLogoutDialog = isDialogOpen)
//        }
//    }
//
//    fun showSecondLogoutDialog(isDialogOpen: Boolean) {
//        setState {state->
//            state.copy(isShowSecondLogoutDialog = isDialogOpen)
//        }
//    }

}