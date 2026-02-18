package com.example.examencalculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.examencalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,
    CalculadoraFragment.ComunicacionCalculadora {

    lateinit var binding: ActivityMainBinding
    lateinit var db: BD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this,
            BD::class.java,
            "calculadora_db"
        ).allowMainThreadQueries().build()
    }

    override fun guardarOperacion(op: Operacion) {
        db.operacionDao()?.insertar(op)
    }
}