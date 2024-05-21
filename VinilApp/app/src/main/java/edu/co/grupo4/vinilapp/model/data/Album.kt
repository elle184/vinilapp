package edu.co.grupo4.vinilapp.model.data

import java.io.Serializable
data class Album(
    val id : Int
    , val name : String
    , val cover : String
    //, val releaseDate : Date
    , val description : String
    //, val genres: Genre
    //, val recordLabel : RecordLabel
    ):Serializable
