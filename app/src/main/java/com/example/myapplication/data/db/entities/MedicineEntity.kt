package com.example.myapplication.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MedicineEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val dose: String,
    val strength: String
)