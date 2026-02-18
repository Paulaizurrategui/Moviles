package com.example.examencalculadora

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Operacion::class], version = 1)
abstract class BD : RoomDatabase() {
    abstract fun operacionDao(): OperacionDao?
}

