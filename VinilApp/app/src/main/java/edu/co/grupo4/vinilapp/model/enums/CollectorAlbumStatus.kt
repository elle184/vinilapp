package edu.co.grupo4.vinilapp.model.enums

enum class CollectorAlbumStatus {

    ACTIVE {
        override fun statusName() : String = "Active"
    }
    , INACTIVE {
        override fun statusName() : String = "Inactive"
    };

    abstract fun statusName() : String
}