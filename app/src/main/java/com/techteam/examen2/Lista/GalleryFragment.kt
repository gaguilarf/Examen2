package com.techteam.examen2.Lista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techteam.examen2.Plano.Edificacion
import com.techteam.examen2.Plano.EdificacionAdapter
import com.techteam.examen2.R

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var edificaciones: MutableList<Edificacion>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_gallery, container, false)

        // Inicializar RecyclerView
        recyclerView = rootView.findViewById(R.id.list_places)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        edificaciones = getEdificaciones().toMutableList()

        val adapter = EdificacionAdapter(edificaciones) { position ->
            val edificacion = edificaciones[position]
        }

        // Asignar el adaptador al RecyclerView

        recyclerView.adapter = adapter
        return rootView
    }

    private fun getEdificaciones(): List<Edificacion> {
        return listOf(
            Edificacion(
                id = 1,
                titulo = "La noche estrellada",
                description = "La noche estrellada es un óleo sobre lienzo del pintor postimpresionista neerlandés Vincent van Gogh. Pintado en junio de 1889, representa la vista desde la ventana orientada al este de su habitación de asilo en Saint-Rémy-de-Provence, justo antes del amanecer, con la adición de un pueblo imaginario.",
                autor = "Vincent van Gogh",
                image = R.drawable.image001 // Reemplazar con el ID del recurso correcto
            ),
            Edificacion(
                id = 2,
                titulo = "La joven de la perla",
                description = "La joven de la perla, también conocida como Muchacha con turbante, es una de las obras maestras del pintor neerlandés Johannes Vermeer realizada entre 1665 y 1667. Como el nombre indica, utiliza un pendiente de perla como punto focal. La pintura se encuentra actualmente en el museo Mauritshuis de La Haya.",
                autor = "Johannes Vermeer",
                image = R.drawable.image002 // Reemplazar con el ID del recurso correcto
            ),
            Edificacion(
                id = 3,
                titulo = "La Gioconda",
                description = "El retrato de Lisa Gherardini, esposa de Francesco del Giocondo, más conocido como La Gioconda o Monna Lisa, es una obra pictórica del polímata renacentista italiano Leonardo da Vinci. Fue adquirida por el rey Francisco I de Francia a comienzos del siglo XVI y desde entonces es propiedad del Estado francés.",
                autor = "Leonardo da Vinci",
                image = R.drawable.image003 // Reemplazar con el ID del recurso correcto
            ),
            Edificacion(
                id = 4,
                titulo = "Las meninas",
                description = "Las meninas o La familia de Felipe IV se considera la obra maestra del pintor del Siglo de Oro español Diego Velázquez. Acabado en 1656, según Antonio Palomino, fecha unánimemente aceptada por la crítica, corresponde al último periodo estilístico del artista, el de plena madurez.",
                autor = "Diego Velázquez",
                image = R.drawable.image004 // Reemplazar con el ID del recurso correcto
            ),
            Edificacion(
                id = 5,
                titulo = "La última cena",
                description = "La última cena es una pintura mural original de Leonardo da Vinci ejecutada entre 1495 y 1498. Se encuentra en la pared sobre la que se pintó originalmente, en el refectorio del convento dominico de Santa Maria delle Grazie, en Milán, declarado Patrimonio de la Humanidad por la Unesco en 1980.",
                autor = "Leonardo da Vinci",
                image = R.drawable.image005 // Reemplazar con el ID del recurso correcto
            ),
            Edificacion(
                id = 6,
                titulo = "Monje en la orilla del mar",
                description = "El monje junto al mar es una pintura al óleo del artista romántico alemán Caspar David Friedrich. Fue pintado entre 1808 y 1810 en Dresde y se mostró por primera vez junto con la pintura La abadía en el robledal en la exposición de la Academia de Berlín de 1810.",
                autor = "Caspar David Friedrich",
                image = R.drawable.image006 // Reemplazar con el ID del recurso correcto
            )

            )
    }

}