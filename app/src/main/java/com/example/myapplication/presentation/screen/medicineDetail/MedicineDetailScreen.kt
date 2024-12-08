package com.example.myapplication.presentation.screen.medicineDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.data.db.entities.MedicationEntity
import com.example.myapplication.presentation.components.AppScaffold
import com.example.myapplication.presentation.components.appbar.AppBar
import com.example.myapplication.presentation.components.preview.MyAppPreview
import com.example.myapplication.presentation.components.space.Height
import com.example.myapplication.utils.UiState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Preview
@Composable
fun PreviewDashboardScreen() {
    MyAppPreview {
        MedicineDetailContain(
            onBack = {},
            medicationName ="sadas",
            medicationDose = "10",
            medicationStrength = "dsdfs",

        )

    }
}

@Destination
@Composable
fun MedicineDetailScreen(
    navigator: DestinationsNavigator,
    medicineViewModel: MedicineDetailModel = hiltViewModel(),
    medicationName: String,
    medicationDose: String,
    medicationStrength: String,
) {
    MedicineDetailContain(
        onBack = {
            navigator.popBackStack()
        },
        medicationName = medicationName,
        medicationDose = medicationDose,
        medicationStrength = medicationStrength,
    )


}

@Composable
fun MedicineDetailContain(
    onBack: () -> Unit,
    medicationName: String,
    medicationDose: String,
    medicationStrength: String,
) {
    AppScaffold(
        topBar = {
            AppBar(
                title = "Medicine Detail",
                titleSub = "",
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
            )
        }
    ) {
        Column {
            Text(
                "Name: $medicationName",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            10.Height()
            Text(
                "Dose: $medicationDose",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            10.Height()
            Text(
                "Strength: $medicationStrength",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}