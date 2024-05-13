package edu.co.grupo4.vinilapp


import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.databinding.ActivityListaArtistasBinding
import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.view.model.ArtistaViewModel
import edu.co.grupo4.vinilapp.view.model.ListaArtistaAdapter

class ListaArtistasActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListaArtistasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: ArtistaViewModel by viewModels()

        setContentView(R.layout.activity_lista_artistas)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Artista>()
        val adapter = ListaArtistaAdapter(data)
        viewModel.artistaslv.observe(this, Observer<List<Artista>> {
            it.apply {
                adapter!!.art
            }
        })

        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : ListaArtistaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Artista){
                val intent= Intent(this@ListaArtistasActivity, DetalleArtistaActivity::class.java)
                //intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }

        })



    }



    companion object{
        val NEXT_SCREEN="details_screen"




    }
}