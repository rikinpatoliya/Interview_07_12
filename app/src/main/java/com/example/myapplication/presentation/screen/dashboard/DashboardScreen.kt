package com.example.myapplication.presentation.screen.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.data.db.entities.MedicationEntity
import com.example.myapplication.presentation.components.AppScaffold
import com.example.myapplication.presentation.components.appbar.AppBar
import com.example.myapplication.presentation.components.loading.AppLoading
import com.example.myapplication.presentation.components.preview.MyAppPreview
import com.example.myapplication.presentation.theme.color212529
import com.example.myapplication.presentation.theme.colorDEE2E6
import com.example.myapplication.presentation.theme.gilroyFont
import com.example.myapplication.utils.UiState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.versionx.valetease.presentation.components.error.NoDataFoundWidget
import com.versionx.valetease.utils.ext.collectState

@Preview
@Composable
fun PreviewDashboardScreen() {
    MyAppPreview {
        DashboardContain(
            onBack = {},
            onLogout = {},
            medicationUiState = UiState.Idle,
            onRetry = {},
            onItemClick = {},
            greeting = "Good Morning"
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

@SuppressLint("NewApi")
@Destination
@Composable
fun DashboardScreen(
    navigator: DestinationsNavigator,
    dashboardViewModel: DashboardViewModel = hiltViewModel(),
    userName: String,
) {
    val state by dashboardViewModel.collectState()
    val context = LocalContext.current

    LaunchedEffect(key1 = state.medicineUiState) {
        if (state.medicineUiState is UiState.Idle) {
            dashboardViewModel.getMedicineList()
        }
    }
    DashboardContain(
        onBack = {},
        onLogout = {},
        greeting = "Good ${dashboardViewModel.getTimeOfDayGreeting()}, $userName",
        medicationUiState = state.medicineUiState,
        onRetry = {},
        onItemClick = {},
    )

}

@Composable
fun DashboardContain(
    onBack: () -> Unit,
    onLogout: () -> Unit,
    greeting: String,
    medicationUiState: UiState<List<MedicationEntity>>,
    onRetry: () -> Unit,
    onItemClick: (Any) -> Unit,

    ) {
    AppScaffold(
        topBar = {
            AppBar(
                title = "Dashboard",
                titleSub = "",
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout",
                        )
                    }
                }

            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(greeting)
            Box(modifier = Modifier.fillMaxSize()) {
                when {
                    medicationUiState is UiState.Loading -> {
                        AppLoading(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    medicationUiState is UiState.Error -> {
                        val message = medicationUiState.message
                        NoDataFoundWidget(
                            message,
                            modifier = Modifier.fillMaxSize(),
                            onRetry = onRetry
                        )
                    }

                    medicationUiState is UiState.Empty -> {
                        NoDataFoundWidget(
                            "List Not Found",
                            modifier = Modifier.fillMaxSize(),
                        )
                    }

                    medicationUiState is UiState.Success -> {
                        val medicationList = medicationUiState.data ?: arrayListOf()
                        LazyColumn(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                        ) {
                            items(medicationList.size) { index ->
                                val medicationObj = medicationList[index]
                                Row(
                                    modifier = Modifier
                                        .padding(top = 20.dp, bottom = 20.dp)
                                        .clickable {
                                            onItemClick.invoke(medicationObj)
                                        }
                                ) {
                                    Text(
                                        text = medicationObj.name ?: "-",
                                        color = color212529,
                                        lineHeight = 1.em,
                                        fontFamily = gilroyFont,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.weight(1f)
                                    )
                                    Text(
                                        text = medicationObj.dose ?: "-",
                                        color = color212529,
                                        lineHeight = 1.em,
                                        fontFamily = gilroyFont,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.weight(1f)
                                    )

                                }
                                Text(
                                    text = medicationObj.strength ?: "-",
                                    color = color212529,
                                    lineHeight = 1.em,
                                    fontFamily = gilroyFont,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                HorizontalDivider(
                                    thickness = 1.dp,
                                    color = colorDEE2E6,
                                )
                            }
                        }
                    }
                }
            }
       /* LazyColumn {
            items(medicines.value) { medicine ->
                Card(onClick = { navigator.navigate("detail/${medicine.id}") }) {
                    Text("${medicine.name} - ${medicine.dose} (${medicine.strength})")
                }
            }
        }*/
        }

    }
}