package edu.co.grupo4.vinilapp.view.model

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Collector

class ListaColeccionistaAdapter(private var coleccionistas: List<Collector>): RecyclerView.Adapter<ListaColeccionistaAdapter.ViewHolder>(){

    var coll: List<Collector> = coleccionistas
        set(value){
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_item_lista_coleccionista, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ItemView(coleccionistas[position])




    }
    override fun getItemCount(): Int = coleccionistas.size
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newCollector: List<Collector>) {
        coleccionistas = newCollector
        notifyDataSetChanged()
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        fun ItemView(collector: Collector) {

        }

            val textViewName: TextView = itemView.findViewById(R.id.name_coleccionista_text)
            val textViewTelephone: TextView = itemView.findViewById(R.id.telephone_coleccionista_text)
            val textViewEmail: TextView = itemView.findViewById(R.id.email_coleccionista_text)
        }



    }
