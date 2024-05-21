package edu.co.grupo4.vinilapp.model.data

import java.io.Serializable
data class Artista(
    val Id:Int,
    val nombre:String,
    val imagen: String,
    val descripcion: String,
    val nacimiento: String,

):Serializable
