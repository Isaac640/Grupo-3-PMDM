package es.grupo3.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.grupo3.myapplication.databinding.FragmentGuardiasBinding
import es.grupo3.myapplication.model.Guardia
import es.grupo3.myapplication.viewmodel.ViewModel

class FragmentGuardias : Fragment() {
    private lateinit var binding: FragmentGuardiasBinding
    private lateinit var navController: NavController
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuardiasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        viewModel.cargarGuardias()

        var guardiasFiltered: MutableList<Guardia> = mutableListOf()

        viewModel.guardiasLiveData.observe(viewLifecycleOwner) { guardias ->
            with(binding.recyclerView) {
                var g = guardias.filter {
                    it.estado == "C" && it.profGuardia == null
                }

                viewModel.horariosGuardias.forEach { e ->
                    guardiasFiltered.addAll(g.filter { it.diaSemana == e.diaSemana && it.hora == e.horaGuardia.id })
                }

                adapter =
                    AdapterGuardias(guardiasFiltered, 0) { guardia -> onClickGuardia(guardia) }
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        binding.txtNoResults.isVisible = guardiasFiltered.isEmpty()

        viewModel.estaCargandoLiveData.observe(viewLifecycleOwner) { estaCargando ->
            binding.progressBarCarga.isVisible = estaCargando
            binding.recyclerView.isVisible = !estaCargando
        }
    }

    private fun onClickGuardia(guardia: Guardia) {
        var accion =
            FragmentInicioDirections.actionFragmentInicioToFragmentDetalleGuardia(guardia.id)
        navController.navigate(accion)
    }
}