package edu.co.grupo4.vinilapp.view.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Album


class ListaAlbumAdapter(private val albumes: List<Album>): RecyclerView.Adapter<ListaAlbumAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaAlbumAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_album, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListaAlbumAdapter.ViewHolder, position: Int) {
        val albumViewModel = albumes[position]

        holder.image.setImageResource(albumViewModel.cover.toInt())
        holder.textViewName.text = albumViewModel.name
    }

    override fun getItemCount(): Int {
        return albumes.size
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val image: ImageView = itemView.findViewById(R.id.album_image)
        val textViewName: TextView = itemView.findViewById(R.id.name_album_text)
    }
}