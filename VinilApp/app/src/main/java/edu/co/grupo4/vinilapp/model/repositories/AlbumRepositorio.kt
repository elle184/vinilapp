package edu.co.grupo4.vinilapp.model.repositories

import android.app.Application
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.model.service.network.NetworkServiceAdapter


class AlbumRepositorio (val application: Application) {
    fun refreshData(callback: (List<Album>)->Unit, onError: (VolleyError)->Unit){
        NetworkServiceAdapter.getInstance(application).getListaAlbumes({
            callback(it)
        },
            onError)
    }
}