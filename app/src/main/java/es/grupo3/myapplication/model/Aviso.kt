package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.sql.Date

data class Aviso (
    @SerializedName("id_aviso")
    var id: Int,
    @SerializedName("profesor")
    var profesor: Profesor,
    @SerializedName("horario")
    var horario: Horario,
    @SerializedName("motivo")
    var motivo: String,
    @SerializedName("observaciones")
    var observaciones: String,
    @SerializedName("confirmado")
    var confirmado: Int,
    @SerializedName("anulado")
    var anulado: Int,
    @SerializedName("fechaGuardia")
    var fechaGuardia: String,
    @SerializedName("fechaHoraAviso")
    var fechaHoraAviso: String,
) : Serializable