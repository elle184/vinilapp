package edu.co.grupo4.vinilapp.view.model

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Artista

class ListaArtistaAdapter(private val artistas: List<Artista>): RecyclerView.Adapter<ListaArtistaAdapter.ViewHolder>(){

    var art: List<Artista> = artistas
    set(value){
        field=value
        notifyDataSetChanged()
    }

    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaArtistaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_artista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artistaViewModel = art[position]

        holder.image.setImageResource(artistaViewModel.imagen.toInt())
        holder.textViewName.text = artistaViewModel.nombre
        holder.textViewTipo.text = artistaViewModel.tipo

        holder.itemView.setOnClickListener {
            if (onClickListener != null){
                onClickListener!!.onClick(position, artistaViewModel)
            }
        }
    }

    override fun getItemCount(): Int {
        return art.size
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Artista)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val image: ImageView = itemView.findViewById(R.id.artista_image)
        val textViewName: TextView = itemView.findViewById(R.id.name_artista_text)
        val textViewTipo: TextView = itemView.findViewById(R.id.tipo_artista_text)
    }
}