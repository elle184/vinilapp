package edu.co.grupo4.vinilapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.views.ListaColeccionistaActivity


class OptionsMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_menu)

        val btnListArtistas = findViewById<ImageButton>(R.id.btnListaArtistas)
        btnListArtistas.setOnClickListener {
            val intent = Intent(this, ListaArtistasActivity::class.java)
            startActivity(intent)
        }

        val btnListColeccionista = findViewById<ImageButton>(R.id.btnListColeccionista)
        btnListColeccionista.setOnClickListener {
            val intent = Intent(this, ListaColeccionistaActivity::class.java)
            startActivity(intent)
        }
        val btnListaAlbum = findViewById<ImageButton>(R.id.btnListAlbum)
        btnListaAlbum.setOnClickListener {
            val intent = Intent(this, ListaAlbumesActivity::class.java)
            startActivity(intent)
        }




    }


}
