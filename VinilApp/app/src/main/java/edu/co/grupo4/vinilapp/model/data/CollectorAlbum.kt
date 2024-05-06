package edu.co.grupo4.vinilapp.model.data

import edu.co.grupo4.vinilapp.model.enums.CollectorAlbumStatus

data class CollectorAlbum(
    val id : Int
    , val price : Int
    , val status : CollectorAlbumStatus
    , val album : Album
    , val collector : Collector
)
