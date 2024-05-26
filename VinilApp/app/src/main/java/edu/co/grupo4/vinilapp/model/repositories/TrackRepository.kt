package edu.co.grupo4.vinilapp.model.repositories

import android.app.Application
import edu.co.grupo4.vinilapp.model.service.network.NetworkServiceAdapter
import com.android.volley.VolleyError
import edu.co.grupo4.vinilapp.model.data.Collector
import edu.co.grupo4.vinilapp.model.data.Track

class TrackRepository (val application: Application){
    fun refreshData(callback: (List<Track>)->Unit, onError: (VolleyError)->Unit) {
        //Determinar la fuente de datos que se va a utilizar. Si es necesario consultar la red, ejecutar el siguiente código

        NetworkServiceAdapter.getInstance(application).getTracks({
            //Guardar los coleccionistas de la variable it en un almacén de datos local para uso futuro
            callback(it)
        },
            onError
        )
    }

}
