package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.data.db.entities.MedicationEntity
import com.example.myapplication.domain.repositories.MedicationRepository
import com.example.myapplication.presentation.screen.dashboard.DashboardViewModel
import com.example.myapplication.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.io.IOException
import java.time.LocalTime
import java.time.LocalTime.now

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val medicationRepository: MedicationRepository = mock()
    private lateinit var viewModel: DashboardViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = DashboardViewModel(medicationRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `getMedicineList updates state to Success with medication list when repository returns data`() =
        runTest {
            val medicationList =
                listOf(MedicationEntity(strength = "1", name = "Medication 1", dose = "Dosage 1"))
            whenever(medicationRepository.fetchMedications()).thenReturn(medicationList)

            viewModel.getMedicineList()
            advanceUntilIdle()
            assertEquals(UiState.Success(medicationList), viewModel.state.value.medicineUiState)
        }

    @Test
    fun `getMedicineList updates state to Empty when repository returns empty list`() = runTest {
        whenever(medicationRepository.fetchMedications()).thenReturn(emptyList())

        viewModel.getMedicineList()

        advanceUntilIdle()
        assertEquals(UiState.Empty, viewModel.state.value.medicineUiState)
        verify(medicationRepository).fetchMedications()
    }

    @Test
    fun `getMedicineList updates state to Error when repository throws IOException`() = runTest {
        whenever(medicationRepository.fetchMedications()).thenThrow(RuntimeException("Network error. Please try again later."))

        viewModel.getMedicineList()

        advanceUntilIdle()
        assertEquals(
            UiState.Error("An unexpected error occurred: Network error. Please try again later."),
            viewModel.state.value.medicineUiState
        )
    }

    @Test
    fun `getMedicineList updates state to Error when repository throws Exception`() = runTest {
        val errorMessage = "Some error message"
        whenever(medicationRepository.fetchMedications()).thenThrow(RuntimeException(errorMessage))

        viewModel.getMedicineList()

        advanceUntilIdle()
        assertEquals(
            UiState.Error("An unexpected error occurred: $errorMessage"),
            viewModel.state.value.medicineUiState
        )
    }
}