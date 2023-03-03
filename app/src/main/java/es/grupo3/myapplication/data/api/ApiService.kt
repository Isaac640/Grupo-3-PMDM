package es.grupo3.myapplication.data.api

import es.grupo3.myapplication.model.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val URL_BASE =
    "http://192.168.1.210:8080/"

private val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {
    @POST("login")
    suspend fun iniciarSesion(@Header("user") user: String, @Header("passwd") passwd: String): Int

    @GET("profesor/buscar")
    suspend fun getProfesor(@Query("id") id: Int): Profesor

    @GET("guardia")
    suspend fun getGuardias(): List<Guardia>

    @GET("horario/buscar")
    suspend fun getHorario(@Query("profesorId") profesorId: Int, @Query("diaSemana") diaSemana: Int, @Query("hora") hora: Int): Horario

    @GET("horarioGuardia/buscar")
    suspend fun getHorarioGuardias(@Query("profesorId") profesorId: Int): List<HorarioGuardia>

    @GET("horarioCentro/buscar")
    suspend fun getHorarioCentro(@Query("id") id: Int): HorarioCentro

    @PUT("aviso/add")
    suspend fun crearAviso(@Body aviso: Aviso): Int

    @POST("guardia/add/avisoId")
    suspend fun crearGuardia(@Body avisoId: Int): Boolean

    @POST("guardia/actualizar")
    suspend fun actualizarGuardia(@Body guardia: Guardia): Boolean
}

object Api {
    val retrofitService:ApiService by lazy { retrofit.create(ApiService::class.java) }
}