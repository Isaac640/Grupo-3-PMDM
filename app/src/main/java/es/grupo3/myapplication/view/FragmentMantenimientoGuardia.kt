package es.grupo3.myapplication.view

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.findNavController
import es.grupo3.myapplication.databinding.FragmentMantenimientoGuardiaBinding

class FragmentMantenimientoGuardia : Fragment() {
    lateinit var binding: FragmentMantenimientoGuardiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMantenimientoGuardiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.back.setOnClickListener {
            view.findNavController().navigateUp()
        }

        binding.linearLayoutObservaciones.setOnClickListener {
            binding.txtObservaciones.requestFocus()
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            val visibleBounds = Rect()
            view.getWindowVisibleDisplayFrame(visibleBounds)

            val heightDiff = view.height - visibleBounds.height()
            if (heightDiff <= 0)
            {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }
    }
}