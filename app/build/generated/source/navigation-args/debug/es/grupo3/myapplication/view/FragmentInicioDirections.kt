package es.grupo3.myapplication.view

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import es.grupo3.myapplication.R
import kotlin.Int

public class FragmentInicioDirections private constructor() {
  private data class ActionFragmentInicioToFragmentDetalleGuardia(
    public val guardiaId: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fragmentInicio_to_fragmentDetalleGuardia

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("guardiaId", this.guardiaId)
        return result
      }
  }

  public companion object {
    public fun actionFragmentInicioToFragmentMantenimientoGuardia(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentInicio_to_fragmentMantenimientoGuardia)

    public fun actionFragmentInicioToFragmentDetalleGuardia(guardiaId: Int): NavDirections =
        ActionFragmentInicioToFragmentDetalleGuardia(guardiaId)
  }
}
