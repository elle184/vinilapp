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
import edu.co.grupo4.vinilapp.model.data.Prize
import edu.co.grupo4.vinilapp.view.model.AlbumViewModel
import edu.co.grupo4.vinilapp.view.model.PrizeViewModel

class CrearPremioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_premio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAgregar = findViewById<Button>(R.id.button_agregar_prize)
        btnAgregar.setOnClickListener {
            val organizacion = findViewById<EditText>(R.id.edit_organizacion).text.toString()
            val namePrize = findViewById<EditText>(R.id.edit_prize_name).text.toString()
            val descripcion = findViewById<EditText>(R.id.edit_descripcion_prize).text.toString()

            if (organizacion.isNotEmpty() && namePrize.isNotEmpty() && descripcion.isNotEmpty()){
                val prize = Prize(
                    organization = organizacion,
                    name = namePrize,
                    description = descripcion
                )
                val prizeViewModel = ViewModelProvider(this).get(PrizeViewModel::class.java)
                prizeViewModel.crearPremio(prize)
            }else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        val prizeViewModel = ViewModelProvider(this).get(PrizeViewModel::class.java)
        prizeViewModel.successMessageLv.observe(this, Observer { successMessage ->
            if (!successMessage.isNullOrEmpty()) {
                Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()

            }
        })
        prizeViewModel.errorMessageLv.observe(this, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()

            }
        })

    }
    }
