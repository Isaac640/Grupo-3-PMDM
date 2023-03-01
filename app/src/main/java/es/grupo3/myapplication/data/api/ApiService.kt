package es.grupo3.myapplication.data.api

import es.grupo3.myapplication.model.Guardia
import es.grupo3.myapplication.model.Profesor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val URL_BASE =
    "http://10.0.13.101:8080/"

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
}

object Api {
    val retrofitService:ApiService by lazy { retrofit.create(ApiService::class.java) }
}