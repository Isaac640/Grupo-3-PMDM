// Generated by view binder compiler. Do not edit!
package es.grupo3.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import es.grupo3.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMantenimientoGuardiaBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView back;

  @NonNull
  public final EditText editText;

  @NonNull
  public final ConstraintLayout linearLayoutFalta;

  @NonNull
  public final ConstraintLayout linearLayoutObservaciones;

  @NonNull
  public final ConstraintLayout linearLayoutSustituye;

  @NonNull
  public final ConstraintLayout linearLayoutTitulo;

  @NonNull
  public final ImageView send;

  @NonNull
  public final EditText txtFalta;

  @NonNull
  public final EditText txtObservaciones;

  @NonNull
  public final TextView txtSustituye;

  @NonNull
  public final View view;

  private FragmentMantenimientoGuardiaBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView back, @NonNull EditText editText,
      @NonNull ConstraintLayout linearLayoutFalta,
      @NonNull ConstraintLayout linearLayoutObservaciones,
      @NonNull ConstraintLayout linearLayoutSustituye, @NonNull ConstraintLayout linearLayoutTitulo,
      @NonNull ImageView send, @NonNull EditText txtFalta, @NonNull EditText txtObservaciones,
      @NonNull TextView txtSustituye, @NonNull View view) {
    this.rootView = rootView;
    this.back = back;
    this.editText = editText;
    this.linearLayoutFalta = linearLayoutFalta;
    this.linearLayoutObservaciones = linearLayoutObservaciones;
    this.linearLayoutSustituye = linearLayoutSustituye;
    this.linearLayoutTitulo = linearLayoutTitulo;
    this.send = send;
    this.txtFalta = txtFalta;
    this.txtObservaciones = txtObservaciones;
    this.txtSustituye = txtSustituye;
    this.view = view;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMantenimientoGuardiaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMantenimientoGuardiaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mantenimiento_guardia, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMantenimientoGuardiaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.editText;
      EditText editText = ViewBindings.findChildViewById(rootView, id);
      if (editText == null) {
        break missingId;
      }

      id = R.id.linearLayoutFalta;
      ConstraintLayout linearLayoutFalta = ViewBindings.findChildViewById(rootView, id);
      if (linearLayoutFalta == null) {
        break missingId;
      }

      id = R.id.linearLayoutObservaciones;
      ConstraintLayout linearLayoutObservaciones = ViewBindings.findChildViewById(rootView, id);
      if (linearLayoutObservaciones == null) {
        break missingId;
      }

      id = R.id.linearLayoutSustituye;
      ConstraintLayout linearLayoutSustituye = ViewBindings.findChildViewById(rootView, id);
      if (linearLayoutSustituye == null) {
        break missingId;
      }

      id = R.id.linearLayoutTitulo;
      ConstraintLayout linearLayoutTitulo = ViewBindings.findChildViewById(rootView, id);
      if (linearLayoutTitulo == null) {
        break missingId;
      }

      id = R.id.send;
      ImageView send = ViewBindings.findChildViewById(rootView, id);
      if (send == null) {
        break missingId;
      }

      id = R.id.txtFalta;
      EditText txtFalta = ViewBindings.findChildViewById(rootView, id);
      if (txtFalta == null) {
        break missingId;
      }

      id = R.id.txtObservaciones;
      EditText txtObservaciones = ViewBindings.findChildViewById(rootView, id);
      if (txtObservaciones == null) {
        break missingId;
      }

      id = R.id.txtSustituye;
      TextView txtSustituye = ViewBindings.findChildViewById(rootView, id);
      if (txtSustituye == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new FragmentMantenimientoGuardiaBinding((LinearLayout) rootView, back, editText,
          linearLayoutFalta, linearLayoutObservaciones, linearLayoutSustituye, linearLayoutTitulo,
          send, txtFalta, txtObservaciones, txtSustituye, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
