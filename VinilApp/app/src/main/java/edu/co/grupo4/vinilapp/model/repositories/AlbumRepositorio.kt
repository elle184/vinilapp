package edu.co.grupo4.vinilapp.model.repositories

import android.app.Application
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.model.service.network.NetworkServiceAdapter
import org.json.JSONObject


class AlbumRepositorio (val application: Application) {

    private val networkServiceAdapter = NetworkServiceAdapter.getInstance(application)
    fun refreshData(callback: (List<Album>)->Unit, onError: (VolleyError)->Unit){
        networkServiceAdapter.getListaAlbumes({
            callback(it)
        },
            onError)
    }

    fun agregarAlbum(album: Album, onComplete: (JSONObject) -> Unit, onError: (VolleyError) -> Unit) {
        networkServiceAdapter.postAlbum(album, onComplete, onError)
    }

}