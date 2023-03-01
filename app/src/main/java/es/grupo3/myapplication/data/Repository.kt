package es.grupo3.myapplication.data

import es.grupo3.myapplication.data.api.Api
import es.grupo3.myapplication.model.Guardia
import es.grupo3.myapplication.model.Profesor

class Repository {
    suspend fun iniciarSesion(user: String, passwd: String): Int =
        Api.retrofitService.iniciarSesion(user, passwd)

    suspend fun getProfesor(id: Int): Profesor = Api.retrofitService.getProfesor(id)

    suspend fun getGuardias(): List<Guardia> = Api.retrofitService.getGuardias()
}