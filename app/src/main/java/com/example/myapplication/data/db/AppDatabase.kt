package com.example.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.dao.MedicationDao
import com.example.myapplication.data.db.entities.MedicationEntity


@Database(entities = [MedicationEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MedicineDao(): MedicationDao
}
