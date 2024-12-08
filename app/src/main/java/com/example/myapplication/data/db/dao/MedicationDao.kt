package com.example.myapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.db.entities.MedicationEntity

@Dao
interface MedicationDao {

    @Query("SELECT * FROM medication")
    fun getAllMedication(): List<MedicationEntity>

//    @Query("SELECT * FROM Medicine WHERE id = :id")
//    fun getMedicineById(id: Int): Flow<Medicine>
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedication(medicines: List<MedicationEntity>)
}
