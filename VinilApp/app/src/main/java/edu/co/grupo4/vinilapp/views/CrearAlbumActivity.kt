package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.view.model.AlbumViewModel
import java.util.Date

class CrearAlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_album)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAgregar = findViewById<Button>(R.id.button_agregar)
        btnAgregar.setOnClickListener {
            val albumName = findViewById<EditText>(R.id.album_name).text.toString()
            val genero = findViewById<EditText>(R.id.edit_genero).text.toString()
            val urlImagen = findViewById<EditText>(R.id.edit_imagen).text.toString()
            val descripcion = findViewById<EditText>(R.id.edit_descripcion).text.toString()

            val currentDate = Date().toString()
            val album = Album(name = albumName, genre = genero, cover = urlImagen, description = descripcion, releaseDate = currentDate, id = 1)

            val albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
            albumViewModel.crearAlbum(album)
        }

        val albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        albumViewModel.successMessageLv.observe(this, Observer { successMessage ->
            if (!successMessage.isNullOrEmpty()) {
                Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()
                // Puedes agregar cualquier lógica adicional aquí para manejar el mensaje de éxito.
            }
        })

        albumViewModel.errorMessageLv.observe(this, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                // Puedes agregar cualquier lógica adicional aquí para manejar el mensaje de error.
            }
        })

    }
}