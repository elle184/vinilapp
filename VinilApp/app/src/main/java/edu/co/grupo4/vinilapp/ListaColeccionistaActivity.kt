package edu.co.grupo4.vinilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.model.data.Collector
import edu.co.grupo4.vinilapp.view.model.ListaColeccionistaAdapter

class ListaColeccionistaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.other_toolbar)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_coleccionista)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val coleccionista = ArrayList<Collector>()
        val adapter = ListaColeccionistaAdapter(coleccionista)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : ListaColeccionistaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Collector){
                val intent= Intent(this@ListaColeccionistaActivity, DetalleColeccionistaActivity::class.java)
                //intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }
        })

        }
    companion object{
        val NEXT_SCREEN="details_screen"
    }
    }
