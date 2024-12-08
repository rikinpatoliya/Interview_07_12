package com.example.myapplication.data.repositories

import com.example.myapplication.data.db.dao.MedicationDao
import com.example.myapplication.data.db.entities.MedicationEntity
import com.example.myapplication.data.remote.MedicationApiServices
import com.example.myapplication.domain.repositories.MedicationRepository
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MedicationRepositoryImpl @Inject internal constructor(
    private val medicineRemoteDataSource: MedicationApiServices,
    private val medicationDao: MedicationDao,
//    private val networkUtils: NetworkUtils,
) : MedicationRepository {

    override suspend fun fetchMedications(): List<MedicationEntity> {
        return try {
            val response = medicineRemoteDataSource.getMedications()
            val medications = response.problems.flatMap { it.diabetes }
                .flatMap { it.medications }
                .flatMap { it.medicationsClasses }
                .flatMap { it.className }
                .flatMap { it.associatedDrug }
            val medicationEntities = medications.map {
                MedicationEntity(
                    name = it.name ?: "",
                    dose = it.dose
                        ?: "",
                    strength = it.strength ?: "",
                )
            }
            medicationDao.insertMedication(medicationEntities)
            medicationEntities
        } catch (e: IOException) {
            throw e // Network error
        } catch (e: Exception) {
            throw RuntimeException("Failed to fetch medications: ${e.message}")
        }
    }

//    override suspend fun getMedicineList(): MedicineResponse {
//        val productDTOs = medicineRemoteDataSource.getMedicineList()
//        return productDTOs
//        /*if (networkUtils.isNetworkConnected()) {
//            val cachedProducts = localDataSource.getMedicineList()
//            return if (cachedProducts.isNotEmpty()) {
//                cachedProducts.map { mapper.mapToDomain(it) }
//            } else {
//                val productDTOs = medicineRemoteDataSource.getMedicineList()
//                val products = productDTOs.map { mapper.mapToDomain(it) }
//                localDataSource.insertMedicines(productDTOs.map { mapper.mapToEntity(it) })
//                products
//            }
//
//        } else {
//            return localDataSource.getMedicineList()
//        }*/
//    }
}