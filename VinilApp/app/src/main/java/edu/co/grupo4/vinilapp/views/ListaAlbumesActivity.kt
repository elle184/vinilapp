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
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.view.model.AlbumViewModel
import edu.co.grupo4.vinilapp.views.adapters.ListaAlbumAdapter

class ListaAlbumesActivity : AppCompatActivity() {
    private lateinit var adapter: ListaAlbumAdapter
    private lateinit var albumViewModel: AlbumViewModel
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_lista_albumes)

           val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_album)
           recyclerView.layoutManager = LinearLayoutManager(this)

           adapter = ListaAlbumAdapter(ArrayList())
           recyclerView.adapter = adapter

           albumViewModel = ViewModelProvider(this, AlbumViewModel.Factory(application)).get(AlbumViewModel::class.java)
           albumViewModel.albumslv.observe(this,Observer{
               albums-> albums?.let{
                   adapter.updateData(it)
                }
           })

           albumViewModel.eventNetworkErrorLv.observe(this, Observer{
               isError-> if(isError){
                    showToast("Error de red")
                }
           })
           albumViewModel.isNetworkErrorShownLv.observe(this, Observer{
               isShown->if(isShown){
                    showToast("Error de conexión")
           }
           })

           adapter.setOnClickListener(object: ListaAlbumAdapter.OnClickListener{
               override fun onClick(position: Int, model: Album){
                   val intent= Intent(this@ListaAlbumesActivity, DetalleAlbumActivity::class.java)
                   intent.putExtra(NEXT_SCREEN, model)
                   startActivity(intent)
               }
           })
           //

    }

    companion object{
        val NEXT_SCREEN="details_screen"
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}