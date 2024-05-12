package edu.co.grupo4.vinilapp.view.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.co.grupo4.vinilapp.model.data.Artista
import edu.co.grupo4.vinilapp.model.repositories.ArtistaRepositorio

class ArtistaViewModel (application: Application): AndroidViewModel(application) {
    private val artistaRepositorio = ArtistaRepositorio(application)
    private val artistas = MutableLiveData<List<Artista>>()
    val artistaslv : LiveData<List<Artista>>
        get()=artistas

    private var eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkErrorLv: LiveData<Boolean>
        get()=eventNetworkError

    private var isNetworkErrorShown= MutableLiveData<Boolean>(false)
    val isNetworkErrorShownLv: LiveData<Boolean>
        get()= isNetworkErrorShown

    init{
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork(){
        artistaRepositorio.refreshData({
            artistas.postValue(it)
            eventNetworkError.value=false
            isNetworkErrorShown.value=false
        },{
            eventNetworkError.value=true
        })
    }

    fun onNetworkErrorShown(){
        isNetworkErrorShown.value=true
    }

    class Factory(val app: Application): ViewModelProvider.Factory {
        fun <T : ViewModel> createModel(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ArtistaViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return ArtistaViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}