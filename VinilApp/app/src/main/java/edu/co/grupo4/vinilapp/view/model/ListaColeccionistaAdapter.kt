package edu.co.grupo4.vinilapp.view.model

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Collector

class ListaColeccionistaAdapter(private val coleccionistas: List<Collector>): RecyclerView.Adapter<ListaColeccionistaAdapter.ViewHolder>(){

    private var onClickListener: OnClickListener? = null
    var col: List<Collector> = coleccionistas
        set(value){
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaColeccionistaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista_coleccionista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collectorViewModel = coleccionistas[position]


        holder.textViewName.text = collectorViewModel.name
        holder.textViewTelephone.setText( collectorViewModel.telephone)
        holder.textViewEmail.setText(collectorViewModel.email)



        holder.itemView.setOnClickListener {
            if (onClickListener != null){
                onClickListener!!.onClick(position, collectorViewModel)
            }
        }
    }

    override fun getItemCount(): Int {
        return coleccionistas.size
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Collector)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val textViewName: TextView = itemView.findViewById(R.id.name_coleccionista_text)
        val textViewTelephone: TextView = itemView.findViewById(R.id.telephone_coleccionista_text)
        val textViewEmail: TextView = itemView.findViewById(R.id.email_coleccionista_text)

    }
}