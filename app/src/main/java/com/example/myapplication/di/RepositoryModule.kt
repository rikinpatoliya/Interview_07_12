
package com.example.myapplication.di

import com.example.myapplication.data.repositories.MedicationRepositoryImpl
import com.example.myapplication.domain.repositories.MedicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun medicineRepositoryImpl(medicineRepository: MedicationRepositoryImpl): MedicationRepository
}
