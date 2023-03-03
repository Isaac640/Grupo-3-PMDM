package es.grupo3.myapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import es.grupo3.myapplication.R
import androidx.navigation.findNavController
import es.grupo3.myapplication.data.Repository
import es.grupo3.myapplication.databinding.FragmentDetalleGuardiaBinding
import es.grupo3.myapplication.model.Guardia
import es.grupo3.myapplication.viewmodel.ViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FragmentDetalleGuardia : Fragment() {
    private lateinit var binding: FragmentDetalleGuardiaBinding
    private lateinit var navController: NavController
    private val viewModel: ViewModel by activityViewModels()

    private lateinit var guardia: Guardia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var id: Int = it.get("guardiaId") as Int

            guardia = viewModel.guardiasLiveData.value!!.first { e -> e.id == id }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetalleGuardiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = view.findNavController()

        var fechaList = guardia.fecha.split('-')
        var date: Date = Date(fechaList[0].toInt(), fechaList[1].toInt(), fechaList[2].toInt())

        val stringDia = SimpleDateFormat("EEEE", Locale("es")).format(date).capitalize()
        val stringMes = SimpleDateFormat("MMMM", Locale("es")).format(date).capitalize()
        binding.txtFecha.text = "$stringDia ${fechaList[2].toInt()}, $stringMes"

        binding.txtGrupo.text = guardia.grupo
        binding.txtAula.text = guardia.aula
        binding.txtHora.text = "${guardia.hora}"
        binding.txtObservaciones.text = guardia.observaciones

        binding.txtFalta.text = guardia.profFalta.getFullName()
        binding.txtSusti.text = guardia.profGuardia?.getFullName() ?: ""

        binding.back.setOnClickListener {
            navController.navigateUp()
        }

        if (guardia.estado != "C") {
            binding.button.isVisible = false
            return
        }

        if (guardia.profFalta.id == viewModel.profesor.id) {
            binding.button.text = "Anular"
            binding.button.backgroundTintList = resources.getColorStateList(R.color.red)

            binding.button.setOnClickListener {
                lifecycleScope.launch {
                    guardia.estado = "A"

                    if (!Repository().actualizarGuardia(guardia)) {
                        Toast.makeText(
                            requireContext(),
                            "Error al actualizar la guardia",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@launch
                    }

                    navController.navigateUp()
                }
            }

            return
        }

        if (guardia.profGuardia == null) {
            binding.button.text = "Aceptar"
            binding.button.backgroundTintList = resources.getColorStateList(R.color.green)

            binding.button.setOnClickListener {
                lifecycleScope.launch {
                    guardia.profGuardia = viewModel.profesor

                    if (!Repository().actualizarGuardia(guardia)) {
                        Toast.makeText(
                            requireContext(),
                            "Error al actualizar la guardia",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@launch
                    }

                    navController.navigateUp()
                }
            }

            return
        }

        if (guardia.profGuardia!!.id == viewModel.profesor.id) {
            binding.button.text = "Realizada"
            binding.button.backgroundTintList = resources.getColorStateList(R.color.green)

            binding.button.setOnClickListener {
                lifecycleScope.launch {
                    guardia.estado = "R"

                    if (!Repository().actualizarGuardia(guardia)) {
                        Toast.makeText(
                            requireContext(),
                            "Error al actualizar la guardia",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@launch
                    }

                    navController.navigateUp()
                }
            }

            binding.button2.isVisible = true
            binding.button2.text = "Anular"
            binding.button2.backgroundTintList = resources.getColorStateList(R.color.red)

            binding.button2.setOnClickListener {
                lifecycleScope.launch {
                    guardia.profGuardia = null

                    if (!Repository().actualizarGuardia(guardia)) {
                        Toast.makeText(
                            requireContext(),
                            "Error al actualizar la guardia",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@launch
                    }

                    navController.navigateUp()
                }
            }
        }
    }
}