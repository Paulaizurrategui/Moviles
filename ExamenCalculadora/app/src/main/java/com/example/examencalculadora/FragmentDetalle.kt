package com.example.examencalculadora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.examencalculadora.databinding.FragmentDetalleBinding


class FragmentDetalle : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private lateinit var db: BD

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        db = BD.getDatabase(requireContext())

        val id = arguments?.getInt("idOperacion") ?: 0

        lifecycleScope.launch {
            val op = db.operacionDao().obtenerPorId(id)
            binding.tvDetalle.text =
                "${op.numero1} ${op.operacion} ${op.numero2} = ${op.resultado}"
        }

        return binding.root
    }
}