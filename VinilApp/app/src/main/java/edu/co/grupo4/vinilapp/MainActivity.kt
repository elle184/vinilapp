package edu.co.grupo4.vinilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnColeccionista = findViewById<ImageButton>(R.id.imgBtnColeccionista)
        btnColeccionista.setOnClickListener {
            val intent = Intent(this, OptionsMenu::class.java)
            startActivity(intent)
        }

        val btnVisitante = findViewById<ImageButton>(R.id.imgBtnVisitante)
        btnVisitante.setOnClickListener {
            val intent = Intent(this, OptionsMenu::class.java)
            startActivity(intent)
        }
    }
}