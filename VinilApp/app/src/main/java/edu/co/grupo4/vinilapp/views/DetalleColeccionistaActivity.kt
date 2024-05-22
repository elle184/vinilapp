package edu.co.grupo4.vinilapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.co.grupo4.vinilapp.views.ListaColeccionistaActivity
import edu.co.grupo4.vinilapp.R

import edu.co.grupo4.vinilapp.databinding.ActivityDetalleColeccionistaBinding

import edu.co.grupo4.vinilapp.model.data.Collector

class DetalleColeccionistaActivity : AppCompatActivity() {
    var binding: ActivityDetalleColeccionistaBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleColeccionistaBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detalle_coleccionista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var coleccionista: Collector?= null
        if(intent.hasExtra(ListaColeccionistaActivity.NEXT_SCREEN)){
            coleccionista = intent.getSerializableExtra(ListaColeccionistaActivity.NEXT_SCREEN) as Collector
        }

        if(coleccionista!=null){
            binding?.name?.text=coleccionista.name
            binding?.telephone?.text=coleccionista.telephone
            binding?.email?.text=coleccionista.email

        }
    }
}