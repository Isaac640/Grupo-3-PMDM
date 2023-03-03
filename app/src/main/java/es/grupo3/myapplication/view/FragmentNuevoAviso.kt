package es.grupo3.myapplication.view

import android.R
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import es.grupo3.myapplication.data.Repository
import es.grupo3.myapplication.databinding.FragmentNuevoAvisoBinding
import es.grupo3.myapplication.model.Aviso
import es.grupo3.myapplication.model.Horario
import es.grupo3.myapplication.model.HorarioCentro
import es.grupo3.myapplication.viewmodel.ViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.sql.Date
import java.util.*

class FragmentNuevoAviso : Fragment() {
    lateinit var binding: FragmentNuevoAvisoBinding
    private val viewModel: ViewModel by activityViewModels()
    private lateinit var date: Date
    private var weekDay: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuevoAvisoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.txtFalta.setText(viewModel.profesor.getFullName())

        binding.txtFecha.setOnClickListener {
            var datePickerDialog = DatePickerDialog(requireContext())
            datePickerDialog.datePicker.minDate = Calendar.getInstance().time.time
            datePickerDialog.setOnDateSetListener { datePicker, i, i2, i3 ->
                onDateSet(
                    datePicker,
                    i,
                    i2,
                    i3
                )
            }

            datePickerDialog.show()
        }

        binding.back.setOnClickListener {
            view.findNavController().navigateUp()
        }

        binding.send.setOnClickListener {
            if (!validarDatos()) return@setOnClickListener


            lifecycleScope.launch {
                var horario: Horario = Repository().getHorario(
                    viewModel.profesor.id,
                    weekDay,
                    binding.spinnerHora.selectedItem as Int
                )

                var dia = String.format("%02d", date.day);
                var mes = String.format("%02d", date.month);
                var anio = String.format("%04d", date.year);

                var aviso: Aviso = Aviso(
                    0,
                    viewModel.profesor,
                    horario,
                    "${binding.txtMotivo.text}",
                    "${binding.txtObservaciones.text}",
                    1,
                    0,
                    "$anio-$mes-$dia",
                    "$anio-$mes-$dia",
                )

                println(aviso.toString())

                var avisoId = Repository().crearAviso(aviso)
                println("avisoId: $avisoId")
                if (avisoId == 0 || !Repository().crearGuardia(avisoId)) {
                    Toast.makeText(requireContext(), "Error al crear el aviso", Toast.LENGTH_SHORT)
                        .show()
                    return@launch
                }

                viewModel.cargado = false

                Toast.makeText(requireContext(), "Guardia creada con éxito", Toast.LENGTH_SHORT)
                    .show()
                view.findNavController().navigateUp()
            }
        }

        binding.linearLayoutObservaciones.setOnClickListener {
            binding.txtObservaciones.requestFocus()
            val imm =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            val visibleBounds = Rect()
            view.getWindowVisibleDisplayFrame(visibleBounds)

            val heightDiff = view.height - visibleBounds.height()
            if (heightDiff <= 0) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }
    }

    fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        date = Date(year, month, dayOfMonth)

        val stringDay = SimpleDateFormat("EEEE", Locale("es")).format(date).capitalize()
        val stringMonth = SimpleDateFormat("MMMM", Locale("es")).format(date).capitalize()

        binding.txtFecha.setText("$stringDay $dayOfMonth, $stringMonth")

        weekDay = SimpleDateFormat("u", Locale("es")).format(date).toInt() - 1

        val horas: List<Int> =
            viewModel.horariosGuardias.filter { it.diaSemana == weekDay }.map { it.diaSemana }
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item, horas
        )

        binding.spinnerHora.adapter = adapter
    }

    fun validarDatos(): Boolean {
        if (binding.txtFecha.text.isEmpty()) {
            Toast.makeText(requireContext(), "Debes seleccionar una fecha", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (weekDay < 1 || weekDay > 5) {
            Toast.makeText(
                requireContext(),
                "Debes seleccionar un día entre semana",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (binding.spinnerHora.selectedItem == null) {
            Toast.makeText(
                requireContext(),
                "Debes seleccionar una hora",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }
}