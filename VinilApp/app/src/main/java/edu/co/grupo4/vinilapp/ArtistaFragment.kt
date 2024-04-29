package edu.co.grupo4.vinilapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.databinding.FragmentArtistaBinding
import edu.co.grupo4.vinilapp.model.Artista
import edu.co.grupo4.vinilapp.view.model.ArtistaViewModel

class ArtistaFragment : Fragment() {

    private var _binding: FragmentArtistaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ArtistaViewModel
    private var viewModelAdapter: ItemArtistaFragmentAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtistaBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = ItemArtistaFragmentAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.list
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity){
            "Accede al viewModel luego de onActivityCreated()"
        }
        activity.actionBar?.title="Artistas"
        viewModel = ViewModelProvider(this, ArtistaViewModel.Factory(activity.application)).get(ArtistaViewModel::class.java)
        viewModel.artistaslv.observe(viewLifecycleOwner, Observer<List<Artista>>{
            it.apply {
                viewModelAdapter!!.artistas = this
            }
        })
        viewModel.eventNetworkErrorLv.observe(viewLifecycleOwner, Observer<Boolean>{ isNetworkError ->
            if(isNetworkError) onNetworkError()
        })
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    private fun onNetworkError(){
        if(!viewModel.isNetworkErrorShownLv.value!!){
            Toast.makeText(activity, "Error de Conexión", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }

}