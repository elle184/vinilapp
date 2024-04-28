package edu.co.grupo4.vinilapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.databinding.FragmentItemArtistaBinding
import edu.co.grupo4.vinilapp.model.Artista

class ItemArtistaFragmentAdapter : RecyclerView.Adapter<ItemArtistaFragmentAdapter.ArtistaViewHolder>(){
    var artistas: List<Artista> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistaViewHolder {
        val withDataBinding: FragmentItemArtistaBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ArtistaViewHolder.LAYOUT,
            parent, false)
        return ArtistaViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.artista=artistas[position]
        }
        holder.viewDataBinding.root.setOnClickListener{
            //holder.viewDataBinding.root.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return artistas.size
    }

    class ArtistaViewHolder(val viewDataBinding: FragmentItemArtistaBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root){
        companion object{
            @LayoutRes
            val LAYOUT = R.layout.fragment_item_artista
        }
    }

}