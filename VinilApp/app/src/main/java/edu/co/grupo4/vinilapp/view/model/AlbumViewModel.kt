package edu.co.grupo4.vinilapp.view.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.co.grupo4.vinilapp.model.data.Album

class AlbumViewModel(application : Application) : AndroidViewModel(application) {

    private val _albums : MutableLiveData<List<Album>>
        get() = _albums

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError : LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown : LiveData<Boolean>
            get() = _isNetworkErrorShown

    init {
        //refreshDataFromNetwork()
    }

    /*private fun refreshDataFromNetwork() {
        NetworkServiceAdapter.getInstance(getApplication()).getAlbums({
            _albums.postValue(it)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false }
        , {
            _eventNetworkError.value = true })
    }*/

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    /*class Factory(val app : Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> createModel(modelClass : Class<T>) : T {
            if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlbumViewModel(app) as T
            }

            throw IllegalArgumentException("Unable to build the ViewModel");
        }
    }*/
}