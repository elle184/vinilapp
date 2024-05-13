package edu.co.grupo4.vinilapp.model.service.network

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
import org.json.JSONArray
import org.json.JSONObject


class NetworkServiceAdapter constructor(context: Context) {
    val instance: RequestQueue = Volley.newRequestQueue(context.applicationContext)
    companion object{
        const val BASE_URL= "http://127.0.0.1:3000/"
        var instance: NetworkServiceAdapter? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: NetworkServiceAdapter(context).also {
                    instance = it
                }
            }
    }
    //private val requestQueue: RequestQueue by lazy {
        // applicationContext keeps you from leaking the Activity or BroadcastReceiver if someone passes one in.
        //Volley.newRequestQueue(context.applicationContext)
    //}

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
                            i, Album(
                                id = item.getInt("id"),
                                name = item.getString("name"),
                                cover = item.getString("cover")

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





