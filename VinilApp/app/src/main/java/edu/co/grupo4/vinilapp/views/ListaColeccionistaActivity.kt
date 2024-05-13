package edu.co.grupo4.vinilapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.databinding.ActivityListaColeccionistaBinding
import edu.co.grupo4.vinilapp.model.data.Collector
import edu.co.grupo4.vinilapp.views.adapters.ListaColeccionistaAdapter
import edu.co.grupo4.vinilapp.viewModels.CollectorViewModel

class ListaColeccionistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.other_toolbar)
        enableEdgeToEdge()
        val binding = ActivityListaColeccionistaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: CollectorViewModel by viewModels()
        val coleccionista = ArrayList<Collector>()
        val adapter = ListaColeccionistaAdapter(coleccionista)
        viewModel.collectors.observe(this, Observer<List<Collector>> {
            it.apply {
                adapter!!.col
            }
        })

        setContentView(R.layout.activity_lista_coleccionista)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : ListaColeccionistaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Collector){
                val intent= Intent(this@ListaColeccionistaActivity, DetalleColeccionistaActivity::class.java)
                //intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }
        })

        }
    companion object{
        val NEXT_SCREEN="details_screen"
    }
    }
