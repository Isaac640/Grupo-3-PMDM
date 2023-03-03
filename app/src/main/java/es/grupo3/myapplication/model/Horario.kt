package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Horario (
        @SerializedName("id")
        var id: Int,
        @SerializedName("aula")
        var aula: String,
        @SerializedName("dia_semana")
        var diaSemana: Int,
        @SerializedName("genera_guardia")
        var generaGuardia: Int,
        @SerializedName("grupo")
        var grupo: String,
        @SerializedName("materia")
        var materia: String,
        @SerializedName("horariocentro")
        var hora: HorarioCentro,
        @SerializedName("profesor")
        var profesor: Profesor,
) : Serializable