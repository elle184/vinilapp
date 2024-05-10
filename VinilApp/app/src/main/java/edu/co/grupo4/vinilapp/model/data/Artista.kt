package edu.co.grupo4.vinilapp.model.data

import java.io.Serializable
data class Artista(
    val artistaId:Int,
    val nombre:String,
    val imagen: String,
    val descripcion: String,
    val nacimiento: String,
    val creacion: String,
    val tipo: String,
    val bandaId: Int
):Serializable
