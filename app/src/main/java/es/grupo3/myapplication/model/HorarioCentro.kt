package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.sql.Time

data class HorarioCentro(
    @SerializedName("id")
    var id: Int,
    @SerializedName("horainicio")
    var horaInicio: String,
    @SerializedName("horafin")
    var horaFin: String,
    @SerializedName("turno")
    var turno: String,
) : Serializable