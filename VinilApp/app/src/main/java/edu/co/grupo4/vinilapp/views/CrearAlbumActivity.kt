package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isNotEmpty
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.model.enums.Genre
import edu.co.grupo4.vinilapp.model.enums.RecordLabel
import edu.co.grupo4.vinilapp.view.model.AlbumViewModel

class CrearAlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_album)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerGenero: Spinner = findViewById(R.id.spinner_genero)
        val adapterG = ArrayAdapter(this, android.R.layout.simple_spinner_item, Genre.values())
        adapterG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenero.adapter= adapterG

        val spinnerRecord: Spinner = findViewById(R.id.spinner_record)
        val adapterR = ArrayAdapter(this, android.R.layout.simple_spinner_item, RecordLabel.values())
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRecord.adapter= adapterR

        val btnAgregar = findViewById<Button>(R.id.button_agregar)
        btnAgregar.setOnClickListener {
            val albumName = findViewById<EditText>(R.id.album_name).text.toString()
            val urlImagen = findViewById<EditText>(R.id.edit_imagen).text.toString()
            val descripcion = findViewById<EditText>(R.id.edit_descripcion).text.toString()
            val release = findViewById<EditText>(R.id.edit_date).text.toString()

            if (albumName.isNotEmpty() && spinnerGenero.isNotEmpty() && urlImagen.isNotEmpty() && descripcion.isNotEmpty() && release.isNotEmpty() && spinnerRecord.isNotEmpty()) {

                val album = Album(
                    name = albumName,
                    genre = "Salsa",
                    recordLabel ="Sony Music",
                    cover = urlImagen,
                    description = descripcion,
                    releaseDate = release
                )

                val albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
                albumViewModel.crearAlbum(album)
            }else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }

        }

        val albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        albumViewModel.successMessageLv.observe(this, Observer { successMessage ->
            if (!successMessage.isNullOrEmpty()) {
                Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()

            }
        })

        albumViewModel.errorMessageLv.observe(this, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()

            }
        })

    }
}