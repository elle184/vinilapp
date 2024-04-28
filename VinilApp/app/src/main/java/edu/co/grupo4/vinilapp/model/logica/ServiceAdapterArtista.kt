package edu.co.grupo4.vinilapp.model.logica

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest
import edu.co.grupo4.vinilapp.model.Artista
import org.json.JSONArray

class ServiceAdapterArtista constructor(context: Context) {
    companion object{
        const val BASE_URL= "http:localhost:3000"
        var instance: ServiceAdapterArtista? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this){
                instance ?: ServiceAdapterArtista(context).also {
                    instance = it
                }
            }
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun getListaArtistas(onComplete:(resp:List<Artista>)->Unit, onError: (error: VolleyError)->Unit) {
        requestQueue.add(
            getRequest("performers",
                Response.Listener<String> { response ->
                    val resp = JSONArray(response)
                    val list = mutableListOf<Artista>()
                    for (i in 0 until resp.length()) {
                        val item = resp.getJSONObject(i)
                        list.add(
                            i, Artista(
                                artistaId = item.getInt("id"),
                                nombre = item.getString("name"),
                                imagen = item.getString("image"),
                                descripcion = item.getString("description"),
                                nacimiento = item.getString("birthDate"),
                                creacion = item.getString("creationDate"),
                                tipo = item.getString("type"),
                                bandaId = item.getInt("bandId")
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
        return StringRequest(Request.Method.GET, BASE_URL +path, responseListener, errorListener)
    }
}