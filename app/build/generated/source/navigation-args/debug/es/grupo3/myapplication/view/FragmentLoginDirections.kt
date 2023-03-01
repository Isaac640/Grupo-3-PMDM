package es.grupo3.myapplication.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import es.grupo3.myapplication.R

public class FragmentLoginDirections private constructor() {
  public companion object {
    public fun actionFragmentLoginToFragmentInicio(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentInicio)
  }
}
