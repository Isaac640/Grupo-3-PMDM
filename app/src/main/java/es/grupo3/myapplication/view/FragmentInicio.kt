package es.grupo3.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import es.grupo3.myapplication.R
import es.grupo3.myapplication.databinding.FragmentInicioBinding

class FragmentInicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPagerAdapter =
            ViewPagerAdapter(requireActivity().supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.signOut.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentLogin)
        }

        binding.btnNueva.setOnClickListener {
            val action = FragmentInicioDirections.actionFragmentInicioToFragmentMantenimientoGuardia()
            view.findNavController().navigate(action)
        }

        cancelGoBack(requireActivity(), viewLifecycleOwner)
    }
}