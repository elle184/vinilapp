package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import edu.co.grupo4.vinilapp.databinding.ActivityDetalleArtistaBinding
import edu.co.grupo4.vinilapp.model.data.Artista
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetalleArtistaActivity : AppCompatActivity() {

    private var binding: ActivityDetalleArtistaBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleArtistaBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding?.main!!) { v, insets ->
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
            binding?.headerImage?.load(artista.imagen)
            //binding?.date?.text=artista.nacimiento
            binding?.body?.text=artista.descripcion

            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val date: Date? = try{
                inputFormat.parse(artista.nacimiento)
            } catch(e: Exception) {
                null
            }

            val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val fecha: String? = date?.let { outputFormat.format(it) }
            fecha?.let {
                binding?.date?.text=fecha
            } ?: run{
                binding?.date?.text="Fecha invalida"
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}