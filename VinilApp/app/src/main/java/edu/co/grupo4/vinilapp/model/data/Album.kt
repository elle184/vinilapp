package edu.co.grupo4.vinilapp.model.data

import edu.co.grupo4.vinilapp.model.enums.Genre
import edu.co.grupo4.vinilapp.model.enums.RecordLabel
import java.util.Date

data class Album(
    val id : Int
    , val name : String
    , val cover : String
    , val releaseDate : Date
    , val description : String
    , val genres: Genre
    , val recordLabel : RecordLabel)
