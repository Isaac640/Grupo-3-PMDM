package es.grupo3.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.grupo3.myapplication.data.Repository
import es.grupo3.myapplication.model.Guardia
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest

class ViewModel : ViewModel() {
    val guardiasLiveData = MutableLiveData<List<Guardia>>()
    val estaCargandoLiveData = MutableLiveData<Boolean>()
    private var cargado = false

    private val repository = Repository()

    fun iniciarSesion(user: String, passwd: String): Int {
        var id: Int = 0

        println(user)
        println(passwd)

        viewModelScope.launch {
            id = repository.iniciarSesion(user, passwd)
        }

        return id
    }

    fun cargarGuardias() {
        viewModelScope.launch {
            if (!cargado) {
                var guardias: List<Guardia> = repository.get()

                estaCargandoLiveData.postValue(true)
                guardiasLiveData.postValue(guardias)
                estaCargandoLiveData.postValue(false)
                cargado = true
            }
        }
    }

    private fun onClickGuardia(guardia: Guardia) {
    }

    fun encryptMD5(input: String): String {
        //81dc9bdb52d04dc20036dbd8313ed055

        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16);
    }
}