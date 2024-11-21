package com.techteam.examen2.Plano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.techteam.examen2.R
import com.techteam.examen2.databinding.ActivityMainBinding
import com.techteam.examen2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var edificaciones: MutableList<Edificacion>
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentHomeBinding.inflate(layoutInflater)
        val img = binding.imageView2

        img.setOnClickListener {
            // Crea una instancia del nuevo Fragment
            val nuevoFragment = EstructuraFragment()

            // Realiza la transacción para reemplazar el Fragment actual
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, nuevoFragment) // 'fragment_container' es el id del contenedor en tu layout principal
                .addToBackStack(null) // Agrega la transacción a la pila de retroceso (opcional)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}