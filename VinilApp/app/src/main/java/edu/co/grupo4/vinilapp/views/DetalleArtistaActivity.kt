package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.databinding.ActivityDetalleArtistaBinding
import edu.co.grupo4.vinilapp.model.data.Artista

class DetalleArtistaActivity : AppCompatActivity() {

    var binding: ActivityDetalleArtistaBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleArtistaBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detalle_artista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var artista: Artista?= null
        if(intent.hasExtra(ListaArtistasActivity.NEXT_SCREEN)){
           artista = intent.getSerializableExtra(ListaArtistasActivity.NEXT_SCREEN) as Artista
        }

        if(artista!=null){
            binding?.title?.text=artista.nombre
            binding?.date?.text=artista.nacimiento
            binding?.body?.text=artista.descripcion


        }
    }
}