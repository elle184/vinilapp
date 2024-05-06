package edu.co.grupo4.vinilapp.model.repositories

import android.app.Application
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.model.service.ServiceAdapterArtista

class ArtistaRepositorio (val application: Application){
    fun refreshData(callback: (List<Artista>)->Unit, onError: (VolleyError)->Unit){
        ServiceAdapterArtista.getInstance(application).getListaArtistas({
            callback(it)
        },
            onError)
    }
}