package es.grupo3.myapplication.data

import es.grupo3.myapplication.data.api.Api
import es.grupo3.myapplication.model.*

class Repository {
    suspend fun iniciarSesion(user: String, passwd: String): Int =
        Api.retrofitService.iniciarSesion(user, passwd)

    suspend fun getProfesor(id: Int): Profesor = Api.retrofitService.getProfesor(id)

    suspend fun getGuardias(): List<Guardia> = Api.retrofitService.getGuardias()

    suspend fun getHorario(profesorId: Int, diaSemana: Int, hora: Int): Horario = Api.retrofitService.getHorario(profesorId, diaSemana, hora)

    suspend fun getHorarioGuardias(profesorId: Int): List<HorarioGuardia> = Api.retrofitService.getHorarioGuardias(profesorId)

    suspend fun getHorarioCentro(id: Int): HorarioCentro = Api.retrofitService.getHorarioCentro(id)

    suspend fun crearAviso(aviso: Aviso): Int = Api.retrofitService.crearAviso(aviso)

    suspend fun crearGuardia(avisoId: Int): Boolean = Api.retrofitService.crearGuardia(avisoId)

    suspend fun actualizarGuardia(guardia: Guardia): Boolean = Api.retrofitService.actualizarGuardia(guardia)
}