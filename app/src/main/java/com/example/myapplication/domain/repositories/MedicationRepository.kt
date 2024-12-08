package com.example.myapplication.domain.repositories


import com.example.myapplication.data.db.entities.MedicationEntity
import javax.inject.Singleton

@Singleton
interface MedicationRepository {

    suspend fun fetchMedications(): List<MedicationEntity>
}