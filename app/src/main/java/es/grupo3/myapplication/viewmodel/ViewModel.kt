package es.grupo3.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.grupo3.myapplication.data.Repository
import es.grupo3.myapplication.model.*
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest
import java.lang.Exception

class ViewModel : ViewModel() {
    lateinit var profesor: Profesor
    var horariosGuardias: List<HorarioGuardia> = listOf()

    val guardiasLiveData = MutableLiveData<List<Guardia>>()
    val estaCargandoLiveData = MutableLiveData<Boolean>()
    var cargado = false

    private val repository = Repository()

    fun cargarGuardias() {
        viewModelScope.launch {
            if (!cargado) {
                var guardias: List<Guardia> = repository.getGuardias()
                horariosGuardias = repository.getHorarioGuardias(profesor.id)

                estaCargandoLiveData.postValue(true)
                guardiasLiveData.postValue(guardias)
                estaCargandoLiveData.postValue(false)
                cargado = true
            }
        }
    }

    fun filtrar(filtro: String) {
        var guardiasFiltradas = guardiasLiveData.value?.filter {
            it.grupo.contains(filtro) || it.aula.contains(filtro) || it.profFalta.getFullName()
                .contains(filtro)
        }?.toList()

        guardiasLiveData.postValue(guardiasFiltradas ?: guardiasLiveData.value)
    }

    fun encryptMD5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16);
    }
}