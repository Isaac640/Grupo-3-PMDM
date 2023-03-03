package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HorarioGuardia(
    @SerializedName("id")
    var id: Int,
    @SerializedName("diaSemana")
    var diaSemana: Int,
    @SerializedName("realizadas")
    var realizadas: Int,
    @SerializedName("horariocentro")
    var horaGuardia : HorarioCentro,
    @SerializedName("profesor")
    var profesor: Profesor,
) : Serializable