package es.grupo3.myapplication.view

import LoginStorageHelper
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import es.grupo3.myapplication.R
import es.grupo3.myapplication.databinding.FragmentInicioBinding
import es.grupo3.myapplication.viewmodel.ViewModel

class FragmentInicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPagerAdapter =
            //ViewPagerAdapter(requireActivity().supportFragmentManager)
            ViewPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.txtBuscar.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                viewModel.filtrar("${binding.txtBuscar.text}")
                return@OnKeyListener true
            }
            false
        })

        binding.signOut.setOnClickListener {
            LoginStorageHelper(requireContext()).removeLogin()
            viewModel.cargado = false
            view.findNavController().navigate(R.id.fragmentLogin)
        }

        binding.btnNueva.setOnClickListener {
            val action =
                FragmentInicioDirections.actionFragmentInicioToFragmentMantenimientoGuardia()
            view.findNavController().navigate(action)
        }

        cancelGoBack(requireActivity(), viewLifecycleOwner)
    }
}