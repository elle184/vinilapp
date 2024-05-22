package edu.co.grupo4.vinilapp.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Artista

class ListaArtistaAdapter(private var artistas: List<Artista>): RecyclerView.Adapter<ListaArtistaAdapter.ViewHolder>(){

    var art: List<Artista> = artistas
        set(value){
            field=value
            notifyDataSetChanged()
        }
    private var onClickListener: ListaArtistaAdapter.OnClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaArtistaAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_item_lista_artista, parent, false)
        return ListaArtistaAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaArtistaAdapter.ViewHolder, position: Int) {
        val artistaViewModel = artistas[position]

        holder.image.setImageResource(artistaViewModel.imagen.toInt())
        holder.textViewName.setText(artistaViewModel.nombre)


        holder.itemView.setOnClickListener {
            if (onClickListener != null){
                onClickListener!!.onClick(position, artistaViewModel)
            }
        }
    }

    override fun getItemCount(): Int = artistas.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newArtista: List<Artista>) {
        artistas = newArtista
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Artista)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val image: ImageView = itemView.findViewById(R.id.artista_image)
        val textViewName: TextView = itemView.findViewById(R.id.nameArtistatext)

    }
}