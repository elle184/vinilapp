package edu.co.grupo4.vinilapp.model.service.network

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import edu.co.grupo4.vinilapp.model.data.Album

import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.model.data.Collector
import edu.co.grupo4.vinilapp.model.data.Prize
import edu.co.grupo4.vinilapp.model.data.Track
import org.json.JSONArray
import org.json.JSONObject


class NetworkServiceAdapter constructor(context: Context) {
    val instance: RequestQueue = Volley.newRequestQueue(context.applicationContext)
    companion object{
        //const val BASE_URL= "http://127.0.0.1:3000/"
        const val BASE_URL = "https://backvynils-q6yc.onrender.com/"
        var instance: NetworkServiceAdapter? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: NetworkServiceAdapter(context).also {
                    instance = it
                }
            }
    }
    private val requestQueue: RequestQueue by lazy {

         Volley.newRequestQueue(context.applicationContext)
    }
    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }

    fun getCollectors(onComplete:(resp:List<Collector>)->Unit, onError: (error:VolleyError)->Unit) {
            instance.add(getRequest("collectors/",
            Response.Listener<String> { response ->
                Log.d("tagb", response)
                val resp = JSONArray(response)
                val list = mutableListOf<Collector>()
                for (i in 0 until resp.length()) {
                    val item = resp.getJSONObject(i)
                    list.add(i, Collector(Id = item.getInt("id"),name = item.getString("name"), telephone = item.getString("telephone"), email = item.getString("email")))
                }
                onComplete(list)
            },
            Response.ErrorListener {
                onError(it)
                Log.d("", it.message.toString())
            }))
    }

    fun getListaArtistas(onComplete:(resp:List<Artista>)->Unit, onError: (error: VolleyError)->Unit) {

        instance.add(
            getRequest("musicians",

                Response.Listener<String> { response ->
                    val resp = JSONArray(response)
                    val list = mutableListOf<Artista>()
                    for (i in 0 until resp.length()) {
                        val item = resp.getJSONObject(i)
                        list.add(
                            i, Artista(

                                Id = item.getInt("id"),
                                nombre = item.getString("name"),
                                imagen = item.getString("image"),
                                descripcion = item.getString("description"),
                                nacimiento = item.getString("birthDate")


                                
                            )
                        )
                    }
                    onComplete(list)
                },
                Response.ErrorListener {
                    onError(it)
                })
        )
    }

    fun getListaAlbumes(onComplete:(resp:List<Album>)->Unit, onError: (error: VolleyError)->Unit) {
        instance.add(
            getRequest("albums",
                Response.Listener<String> { response ->
                    val resp = JSONArray(response)
                    val list = mutableListOf<Album>()
                    for (i in 0 until resp.length()) {
                        val item = resp.getJSONObject(i)
                        list.add(
                            i, Album(name = item.getString("name"),
                                cover = item.getString("cover"),
                                description = item.getString("description"),
                                releaseDate = item.getString("releaseDate"),
                                genre = item.getString("genre"),
                                recordLabel = item.getString("recordLabel"))
                        )
                    }
                    onComplete(list)
                },
                Response.ErrorListener {
                    onError(it)
                })
        )
    }

    fun getTracks(onComplete:(resp:List<Track>)->Unit, onError: (error: VolleyError)->Unit) {
        instance.add(
            getRequest("Track",
                Response.Listener<String> { response ->
                    val resp = JSONArray(response)
                    val list = mutableListOf<Track>()
                    for (i in 0 until resp.length()) {
                        val item = resp.getJSONObject(i)
                        list.add(
                            i, Track(
                                id = item.getInt("id"),
                                name = item.getString("name"),
                                duration = item.getString("duration"),
                                album = item.getString("album"),
                                )
                        )
                    }
                    onComplete(list)
                },
                Response.ErrorListener {
                    onError(it)
                })
        )
    }

    fun postAlbum(album: Album, onComplete: (response: JSONObject) -> Unit, onError: (error: VolleyError) -> Unit) {
        val albumJson = JSONObject().apply {

            put("name", album.name)
            put("cover", album.cover)
            put("releaseDate", album.releaseDate)
            put("description", album.description)
            put("genre", album.genre)
            put("recordLabel", album.recordLabel)
        }

        instance.add(
            postRequest("albums/",
                JSONObject().apply {

                    put("name", album.name)
                    put("cover", album.cover)
                    put("releaseDate", album.releaseDate)
                    put("description", album.description)
                    put("genre", album.genre)
                    put("recordLabel", album.recordLabel)
                },
                Response.Listener { response ->
                    onComplete(response)
                },
                Response.ErrorListener { error ->
                    onError(error)
                }
            )
        )
        Log.d("JSON", albumJson.toString())

    }

    fun postPrize(prize: Prize, onComplete: (response: JSONObject) -> Unit, onError: (error: VolleyError) -> Unit) {
        val prizeJson = JSONObject().apply {
            put("organization", prize.organization)
            put("name", prize.name)
            put("description", prize.description)
        }

        instance.add(
            postRequest("prizes/",
                JSONObject().apply {
                    put("organization", prize.organization)
                    put("name", prize.name)
                    put("description", prize.description)
                },
                Response.Listener { response ->
                    onComplete(response)
                },
                Response.ErrorListener { error ->
                    onError(error)
                }
            )
        )
        Log.d("JSON", prizeJson.toString())

    }


    private fun getRequest(path:String, responseListener: Response.Listener<String>, errorListener: Response.ErrorListener): StringRequest {
        return StringRequest(Request.Method.GET, BASE_URL + path, responseListener, errorListener)
    }
    private fun postRequest(path: String, body: JSONObject, responseListener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener ):JsonObjectRequest{
        return  JsonObjectRequest(Request.Method.POST, BASE_URL +path, body, responseListener, errorListener)
    }
    private fun putRequest(path: String, body: JSONObject, responseListener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener ):JsonObjectRequest{
        return  JsonObjectRequest(Request.Method.PUT, BASE_URL +path, body, responseListener, errorListener)
    }

}





