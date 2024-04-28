package edu.co.grupo4.vinilapp.model.logica

import android.app.Application
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.Artista

class ArtistaRepositorio (val application: Application){
    fun refreshData(callback: (List<Artista>)->Unit, onError: (VolleyError)->Unit){
        ServiceAdapterArtista.getInstance(application).getListaArtistas({
            callback(it)
        },
            onError)
    }
}