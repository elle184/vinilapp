package edu.co.grupo4.vinilapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.view.model.ListaArtistaAdapter

class ListaArtistasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_artistas)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Artista>()

        val adapter = ListaArtistaAdapter(data)

        recyclerView.adapter = adapter

    }
}