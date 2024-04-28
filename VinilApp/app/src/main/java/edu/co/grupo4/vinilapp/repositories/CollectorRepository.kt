package edu.co.grupo4.vinilapp.repositories

import android.app.Application
import edu.co.grupo4.vinilapp.models.Collector
import edu.co.grupo4.vinilapp.network.NetworkServiceAdapter
import com.android.volley.VolleyError

class CollectorRepository (val application: Application){
    fun refreshData(callback: (List<Collector>)->Unit, onError: (VolleyError)->Unit) {
        //Determinar la fuente de datos que se va a utilizar. Si es necesario consultar la red, ejecutar el siguiente código

        NetworkServiceAdapter.getInstance(application).getCollectors({
            //Guardar los coleccionistas de la variable it en un almacén de datos local para uso futuro
            callback(it)
        },
            onError
        )
    }

}
