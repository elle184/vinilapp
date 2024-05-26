package edu.co.grupo4.vinilapp.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Album


class ListaAlbumAdapter(private var albumes: List<Album>): RecyclerView.Adapter<ListaAlbumAdapter.ViewHolder>(){

    private var onClickListener: ListaAlbumAdapter.OnClickListener? = null

    var alb: List<Album> = albumes
        set(value){
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaAlbumAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_item_lista_album, parent, false)
        return ListaAlbumAdapter.ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListaAlbumAdapter.ViewHolder, position: Int) {
        val albumViewModel = albumes[position]

        holder.image.load(albumViewModel.cover)
        holder.textViewName.setText(albumViewModel.name)

        holder.itemView.setOnClickListener{
            if(onClickListener != null){
                onClickListener!!.onClick(position, albumViewModel)
            }
        }
    }

    override fun getItemCount(): Int = albumes.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newAlbum: List<Album>) {
        albumes = newAlbum
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListener: OnClickListener){
       this.onClickListener = onClickListener
    }

    interface OnClickListener{
        fun onClick(position: Int, model: Album)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val image: ImageView = itemView.findViewById(R.id.album_image)
        val textViewName: TextView = itemView.findViewById(R.id.name_album_text)
    }
}