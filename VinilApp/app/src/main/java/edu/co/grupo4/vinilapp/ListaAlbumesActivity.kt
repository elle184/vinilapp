package edu.co.grupo4.vinilapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.view.model.ListaAlbumAdapter

class ListaAlbumesActivity : AppCompatActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_albumes)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_album)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Album>()

        val adapter = ListaAlbumAdapter(data)

        recyclerView.adapter = adapter


    }
}