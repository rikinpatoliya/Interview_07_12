package com.example.myapplication.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication")
data class MedicationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int= 0,
    val name: String,
    val dose: String,
    val strength: String
)