package es.grupo3.myapplication.data

import es.grupo3.myapplication.data.api.Api
import es.grupo3.myapplication.model.Guardia

class Repository {
    suspend fun get(): List<Guardia> = Api.retrofitService.getGuardias()

    suspend fun iniciarSesion(user: String, passwd: String): Int = Api.retrofitService.iniciarSesion(user, passwd)
}