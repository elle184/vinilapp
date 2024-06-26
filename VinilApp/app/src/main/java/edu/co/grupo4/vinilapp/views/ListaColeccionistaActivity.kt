package edu.co.grupo4.vinilapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.grupo4.vinilapp.R
import edu.co.grupo4.vinilapp.model.data.Collector
import edu.co.grupo4.vinilapp.view.model.ListaColeccionistaAdapter
import edu.co.grupo4.vinilapp.viewModels.CollectorViewModel


class ListaColeccionistaActivity : AppCompatActivity() {
    private lateinit var adapter: ListaColeccionistaAdapter
    private lateinit var coleccionistaViewModel: CollectorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_coleccionista)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ListaColeccionistaAdapter(ArrayList())
        recyclerView.adapter = adapter
        coleccionistaViewModel = ViewModelProvider(this, CollectorViewModel.Factory(application)).get(CollectorViewModel::class.java)
        coleccionistaViewModel.collectors.observe(this, Observer { collectors ->
            collectors?.let {
                adapter.updateData(it)
            }
        })
        coleccionistaViewModel.eventNetworkError.observe(this, Observer { isError ->
            if (isError) {
                showToast("Error de red")
            }
        })
        coleccionistaViewModel.isNetworkErrorShown.observe(this, Observer { isShown ->
            if (isShown) {
                showToast("Error de conexión")
            }
        })
        adapter.setOnClickListener(object : ListaColeccionistaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Collector){
                val intent= Intent(this@ListaColeccionistaActivity, DetalleColeccionistaActivity::class.java)
                intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }

        })

}
    companion object{
        val NEXT_SCREEN="details_screen"
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    }


