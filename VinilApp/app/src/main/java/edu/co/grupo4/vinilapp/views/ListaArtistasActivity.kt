package edu.co.grupo4.vinilapp.views


import android.content.Intent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.view.model.ArtistaViewModel
import edu.co.grupo4.vinilapp.views.adapters.ListaArtistaAdapter

class ListaArtistasActivity : AppCompatActivity() {

    private lateinit var adapter: ListaArtistaAdapter
    private lateinit var artistaViewModel: ArtistaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_artistas)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ListaArtistaAdapter(ArrayList())
        recyclerView.adapter = adapter

        artistaViewModel = ViewModelProvider(this, ArtistaViewModel.Factory(application)).get(
            ArtistaViewModel::class.java)
        artistaViewModel.artistaslv.observe(this, Observer{
                artistas-> artistas?.let{
            adapter.updateData(it)
            }
        })

        artistaViewModel.eventNetworkErrorLv.observe(this, Observer{
                isError-> if(isError) {
                    showToast("Error de red")
              }
        })
        artistaViewModel.isNetworkErrorShownLv.observe(this, Observer{
                isShown->if(isShown){
                    showToast("Error de conexión")
             }
        })



        adapter.setOnClickListener(object : ListaArtistaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Artista){
                val intent= Intent(this@ListaArtistasActivity, DetalleArtistaActivity::class.java)
                intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }

        })
    }

    companion object{
        val NEXT_SCREEN="details_screen"

    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}