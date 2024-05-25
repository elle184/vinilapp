package edu.co.grupo4.vinilapp.view.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.co.grupo4.vinilapp.model.data.Album
import edu.co.grupo4.vinilapp.model.repositories.AlbumRepositorio

class AlbumViewModel(application : Application) : AndroidViewModel(application) {
    private val albumRepositorio = AlbumRepositorio(application)
    private val albums = MutableLiveData<List<Album>>()

    val albumslv : LiveData<List<Album>>
        get()=albums

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

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        albumRepositorio.refreshData({
            albums.postValue(it)
            eventNetworkError.value=false
            isNetworkErrorShown.value=false
        },{
            eventNetworkError.value=true
        })
    }

    fun crearAlbum(album: Album) {
        albumRepositorio.agregarAlbum(album,
            onComplete = {
                successMessage.value = "Álbum agregado exitosamente"
                refreshDataFromNetwork()
            },
            onError = {
                errorMessage.value = "Error al agregar el álbum: ${it.message}"
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
            if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlbumViewModel(app) as T
            }

            throw IllegalArgumentException("Unable to build the ViewModel");
        }
    }
}