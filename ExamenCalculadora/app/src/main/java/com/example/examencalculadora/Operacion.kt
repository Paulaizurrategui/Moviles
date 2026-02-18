package com.example.examencalculadora

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "operaciones")
data class Operacion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val numero1: Double,
    val numero2: Double,
    val operacion: String,
    val resultado: Double
)

