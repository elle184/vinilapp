package edu.co.grupo4.vinilapp.model.data

import java.io.Serializable

data class Album(
   // val id : Int? = null
     val name : String
    , val cover : String
    , val releaseDate : String
    , val description : String
    , val genre: String
    , val recordLabel : String
    ):Serializable
