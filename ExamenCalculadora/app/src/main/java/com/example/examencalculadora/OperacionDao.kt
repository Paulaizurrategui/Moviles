package com.example.examencalculadora

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class OperacionDao {

    @Insert
    abstract fun insertar(op: Operacion)

    @Query("SELECT * FROM operaciones")
    abstract fun obtenerTodas(): List<Operacion>

    @Query("DELETE FROM operaciones")
    abstract fun borrarTodas()

    @Query("SELECT * FROM operaciones WHERE id = :id")
    abstract fun obtenerPorId(id: Int): Operacion
}
