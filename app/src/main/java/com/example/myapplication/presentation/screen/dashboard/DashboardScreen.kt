package com.example.myapplication.presentation.screen.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.presentation.components.preview.MyAppPreview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Preview
@Composable
fun PreviewDashboardScreen() {
    MyAppPreview {
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
@Destination
@Composable
fun DashboardScreen(
    navigator: DestinationsNavigator,
    dashboardViewModel: LoginViewModel = hiltViewModel(),
){

}