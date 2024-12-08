package com.example.myapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.data.db.entities.MedicineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {

    @Query("SELECT * FROM MedicineEntity")
    fun getAllMedicines(): Flow<List<MedicineEntity>>

//    @Query("SELECT * FROM Medicine WHERE id = :id")
//    fun getMedicineById(id: Int): Flow<Medicine>
//
//    @Insert
//    suspend fun insertMedicines(medicines: List<Medicine>)
}
