package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import edu.co.grupo4.vinilapp.databinding.ActivityDetalleAlbumBinding
import edu.co.grupo4.vinilapp.model.data.Album
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetalleAlbumActivity : AppCompatActivity() {
    private var binding: ActivityDetalleAlbumBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleAlbumBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding?.main!!) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var album: Album?= null
        if(intent.hasExtra(ListaAlbumesActivity.NEXT_SCREEN)){
            album = intent.getSerializableExtra(ListaAlbumesActivity.NEXT_SCREEN) as Album
        }

        if(album!=null){
            binding?.title?.text=album.name
            binding?.headerImage?.load(album!!.cover)
            binding?.subtitle?.text=album.genre
            binding?.body?.text = album.description

            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val date: Date? = try{
                inputFormat.parse(album.releaseDate)
            } catch(e: Exception) {
                null
            }

            val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val fecha: String? = date?.let { outputFormat.format(it) }
            fecha?.let {
                binding?.release?.text=fecha
            } ?: run{
                binding?.release?.text="Fecha invalida"
            }

        }
    }
}