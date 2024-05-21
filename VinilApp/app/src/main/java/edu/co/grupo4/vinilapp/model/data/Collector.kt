package edu.co.grupo4.vinilapp.model.data

import java.io.Serializable

data class Collector(
    val Id: Int,
    val name:String,
    val telephone:String,
    val email:String
) : Serializable
