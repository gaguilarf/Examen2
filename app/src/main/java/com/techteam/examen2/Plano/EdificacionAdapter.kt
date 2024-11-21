package com.techteam.examen2.Plano

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techteam.examen2.R

class EdificacionAdapter(
    private val edificaciones: MutableList<Edificacion>,
    private val onLikeClick: (Int) -> Unit // Callback para el clic en el botón "me gusta"
) : RecyclerView.Adapter<EdificacionAdapter.EdificacionViewHolder>() {

    inner class EdificacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.txtTitle)
        val descriptionText: TextView = itemView.findViewById(R.id.txtCat)
        val authorText: TextView = itemView.findViewById(R.id.txtAutor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdificacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return EdificacionViewHolder(view)
       }
//
    override fun onBindViewHolder(holder: EdificacionViewHolder, position: Int) {
        val edificacion = edificaciones[position]

        // Asignar los datos al item
        holder.titleText.text = edificacion.titulo
        holder.descriptionText.text = edificacion.description
        holder.authorText.text = edificacion.autor
    }

    override fun getItemCount(): Int = edificaciones.size
}
