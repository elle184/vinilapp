package edu.co.grupo4.vinilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity


class OptionsMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_menu)

        val btnListArtistas = findViewById<Button>(R.id.btnListaArtistas)
        btnListArtistas.setOnClickListener {
            val intent = Intent(this, ListaArtistasActivity::class.java)
            startActivity(intent)
        }
        val btnListColeccionista = findViewById<ImageButton>(R.id.btnListColeccionista)
        btnListColeccionista.setOnClickListener {
            val intent = Intent(this, ListaColeccionistaActivity::class.java)
            startActivity(intent)
        }

    }


}
