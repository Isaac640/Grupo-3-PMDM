package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Guardia (
    @SerializedName("id")
    var id: Int,
    @SerializedName("aula")
    var aula: String,
    @SerializedName("diaSemana")
    var diaSemana: Int,
    @SerializedName("estado")
    var estado: String,
    @SerializedName("fecha")
    var fecha: String,
    @SerializedName("grupo")
    var grupo: String,
    @SerializedName("hora")
    var hora: Int,
    @SerializedName("observaciones")
    var observaciones: String,
    @SerializedName("avisosGuardia")
    var aviso: Aviso,
    @SerializedName("horario")
    var horario: Horario,
    @SerializedName("profFalta")
    var profFalta: Profesor,
    @SerializedName("profGuardia")
    var profGuardia: Profesor?,
) : Serializable