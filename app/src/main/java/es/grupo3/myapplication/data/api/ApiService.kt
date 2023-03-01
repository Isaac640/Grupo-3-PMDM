package es.grupo3.myapplication.data.api

import es.grupo3.myapplication.model.Guardia
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

private const val URL_BASE =
    "http://192.168.1.210:8080/"

private val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {
    @GET("guardia")
    suspend fun getGuardias(): List<Guardia>

    @POST("login")
    suspend fun iniciarSesion(@Header("user") user: String, @Header("passwd") passwd: String): Int
}

object Api {
    val retrofitService:ApiService by lazy { retrofit.create(ApiService::class.java) }
}