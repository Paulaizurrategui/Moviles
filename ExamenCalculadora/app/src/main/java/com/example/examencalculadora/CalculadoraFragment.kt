package com.example.examencalculadora

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.tool.Context
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CalculadoraFragment : Fragment() {

    interface ComunicacionCalculadora {
        fun guardarOperacion(op: Operacion)
    }

    private lateinit var binding: FragmentCalculadoraBinding
    private lateinit var actividad: ComunicacionCalculadora

    override fun onAttach(context: Context) {
        super.onAttach(context)
        actividad = context as ComunicacionCalculadora
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCalculadoraBinding.inflate(inflater, container, false)

        registerForContextMenu(binding.tvResultado)

        binding.btnSumar.setOnClickListener { calcular("+") }
        binding.btnRestar.setOnClickListener { calcular("-") }
        binding.btnMultiplicar.setOnClickListener { calcular("*") }
        binding.btnDividir.setOnClickListener { calcular("/") }
        binding.btnResto.setOnClickListener { calcular("%") }

        return binding.root
    }

    private fun calcular(op: String) {
        val n1 = binding.etNumero1.text.toString().toDouble()
        val n2 = binding.etNumero2.text.toString().toDouble()

        val resultado = when(op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            "%" -> n1 % n2
            else -> 0.0
        }

        binding.tvResultado.text = resultado.toString()

        val operacion = Operacion(0, n1, n2, op, resultado)
        actividad.guardarOperacion(operacion)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu.add("Limpiar")
        menu.add("Ir a historial")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.title) {
            "Limpiar" -> binding.tvResultado.text = ""
            "Ir a historial" -> findNavController().navigate(R.id.historialFragment)
        }
        return true
    }
}
