package es.grupo3.myapplication.view

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import es.grupo3.myapplication.R
import es.grupo3.myapplication.databinding.FragmentLoginBinding
import es.grupo3.myapplication.viewmodel.ViewModel

class FragmentLogin : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnContinuar.setOnClickListener {

            if (binding.txtUsuario.text.isEmpty() || binding.txtContrasena.text.isEmpty()) {
                Toast.makeText(requireContext(), "Uno o varios campos están vacíos", Toast.LENGTH_SHORT).show()
            } else {
                val id: Int = viewModel.iniciarSesion(binding.txtUsuario.text.toString(), viewModel.encryptMD5(binding.txtContrasena.text.toString()))

                if (id == 0) {
                    Toast.makeText(requireContext(), "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                view.findNavController().navigate(R.id.action_fragmentLogin_to_fragmentInicio)
            }
        }

        cancelGoBack(requireActivity(), viewLifecycleOwner)
    }
}

fun cancelGoBack(activity: FragmentActivity, viewLifecycleOwner: LifecycleOwner) {

    val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            activity.finish()
        }
    }
    activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
}