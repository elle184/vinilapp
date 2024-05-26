package edu.co.grupo4.vinilapp.model.enums

enum class RecordLabel {
    SONY_MUSIC {
        override fun statusName() : String = "Sony Music"
    }
    , EMI {
        override fun statusName() : String = "EMI"
    }
    , DISCOS_FUENTES {
        override fun statusName() : String = "Discos Fuentes"
    }
    , ELEKTRA {
        override fun statusName() : String = "Elektra"
    }
    , FANIA_RECORDS {
        override fun statusName() : String = "Fania Records"
    };

    abstract fun statusName() : String




companion object {
    fun getNames(): List<String> {
        return values().map { it.statusName() }
    }
}
}