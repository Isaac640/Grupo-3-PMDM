package es.grupo3.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Profesor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("activo")
    var activo: Boolean,
    @SerializedName("ape1")
    var ape1: String,
    @SerializedName("ape2")
    var ape2: String,
    @SerializedName("baja")
    var baja: Boolean,
    @SerializedName("deptCod")
    var deptCod: String,
    @SerializedName("dni")
    var dni: String,
    @SerializedName("idSustituye")
    var idSustituye: Int?,
    @SerializedName("nombre")
    var nombre: String,
    @SerializedName("tfno")
    var tfno: String,
    @SerializedName("user")
    var user: String,
) : Serializable