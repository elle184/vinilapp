package edu.co.grupo4.vinilapp.view.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.co.grupo4.vinilapp.model.data.Prize
import edu.co.grupo4.vinilapp.model.repositories.PrizeRepository

class PrizeViewModel(application : Application) : AndroidViewModel(application) {
    private val prizeRepositorio = PrizeRepository(application)

    private var eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkErrorLv : LiveData<Boolean>
        get() = eventNetworkError

    private var isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShownLv : LiveData<Boolean>
        get() = isNetworkErrorShown

    private var successMessage = MutableLiveData<String?>()
    val successMessageLv: MutableLiveData<String?>
        get() = successMessage

    private var errorMessage = MutableLiveData<String?>()
    val errorMessageLv: MutableLiveData<String?>
        get() = errorMessage


    fun crearPremio(prize: Prize) {
        prizeRepositorio.agregarPrize(prize,
            onComplete = {
                successMessage.value = "Premio agregado exitosamente"

            },
            onError = {
                errorMessage.value = "Error al agregar el premio: ${it.message}"
                eventNetworkError.value = true
            }
        )
    }

    fun onNetworkErrorShown() {
        isNetworkErrorShown.value = true
    }

    fun limpiarMensajes() {
        successMessage.value = null
        errorMessage.value = null
    }

    class Factory(val app : Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass : Class<T>) : T {
            if (modelClass.isAssignableFrom(PrizeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PrizeViewModel(app) as T
            }

            throw IllegalArgumentException("Unable to build the ViewModel");
        }
    }

}