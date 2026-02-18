package com.example.examencalculadora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.examencalculadora.databinding.FragmentHistorialBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHistorial.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHistorial : Fragment() {
    private lateinit var binding: FragmentHistorialBinding
    private lateinit var db: BD

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHistorialBinding.inflate(inflater, container, false)

        db = Room.databaseBuilder(
            requireContext(),
            BD::class.java,
            "calculadora_db"
        ).allowMainThreadQueries().build()

        cargarDatos()

        binding.btnBorrar.setOnClickListener {
            db.operacionDao()?.borrarTodas()
            cargarDatos()
        }

        return binding.root
    }

    private fun cargarDatos() {
        val lista = db.operacionDao()?.obtenerTodas()
        binding.tvHistorial.text = lista?.joinToString("\n")
    }

}