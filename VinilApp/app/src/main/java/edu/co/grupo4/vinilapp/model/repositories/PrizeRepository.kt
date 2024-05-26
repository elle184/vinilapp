package edu.co.grupo4.vinilapp.model.repositories

import android.app.Application
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.data.Prize
import edu.co.grupo4.vinilapp.model.service.network.NetworkServiceAdapter
import org.json.JSONObject

class PrizeRepository (val application: Application){

    private val networkServiceAdapter = NetworkServiceAdapter.getInstance(application)

    fun agregarPrize(prize: Prize, onComplete: (JSONObject) -> Unit, onError: (VolleyError) -> Unit) {
        networkServiceAdapter.postPrize(prize, onComplete, onError)
    }

}