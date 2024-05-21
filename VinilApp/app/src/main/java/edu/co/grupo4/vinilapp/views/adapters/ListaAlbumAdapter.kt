package edu.co.grupo4.vinilapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Album


class ListaAlbumAdapter(private val albumes: List<Album>): RecyclerView.Adapter<ListaAlbumAdapter.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    var alb: List<Album> = albumes
        set(value){
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_album, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val albumViewModel = alb[position]

        holder.image.setImageResource(albumViewModel.cover.toInt())
        holder.textViewName.setText(albumViewModel.name)

        holder.itemView.setOnClickListener{
            if(onClickListener != null){
                onClickListener!!.onClick(position, albumViewModel)
            }
        }
    }

    override fun getItemCount(): Int {
        return alb.size
    }

    fun updateData(newAlbums: List<Album>) {
        alb= newAlbums
        notifyDataSetChanged()
    }


    fun setOnclickListener(onClickListener: OnClickListener){
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