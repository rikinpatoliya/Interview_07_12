package com.example.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.dao.MedicineDao
import com.example.myapplication.data.db.entities.MedicineEntity


@Database(entities = [MedicineEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MedicineDao(): MedicineDao
}
