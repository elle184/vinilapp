package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.databinding.ActivityDetalleAlbumBinding
import edu.co.grupo4.vinilapp.model.data.Album

class DetalleAlbumActivity : AppCompatActivity() {
    var binding: ActivityDetalleAlbumBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleAlbumBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detalle_album)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
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
            binding?.songs?.text="10 canciones"
            binding?.body?.text = album.description


        }
    }
}