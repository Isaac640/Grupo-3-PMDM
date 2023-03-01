package es.grupo3.myapplication.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import es.grupo3.myapplication.R

public class FragmentInicioDirections private constructor() {
  public companion object {
    public fun actionFragmentInicioToFragmentMantenimientoGuardia(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentInicio_to_fragmentMantenimientoGuardia)
  }
}
