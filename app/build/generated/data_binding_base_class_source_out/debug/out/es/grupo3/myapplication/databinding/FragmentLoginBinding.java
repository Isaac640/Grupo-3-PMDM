// Generated by view binder compiler. Do not edit!
package es.grupo3.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout ConstraintLayout;

  @NonNull
  public final Button btnContinuar;

  @NonNull
  public final ImageView imvUsuario;

  @NonNull
  public final ImageView ivwContrasena;

  @NonNull
  public final ImageView ivwInicioSesion;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final LinearLayout linearLayoutContrasena;

  @NonNull
  public final LinearLayout lytUsuario;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView tvwInicioSesion;

  @NonNull
  public final EditText txtContrasena;

  @NonNull
  public final EditText txtUsuario;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout ConstraintLayout, @NonNull Button btnContinuar,
      @NonNull ImageView imvUsuario, @NonNull ImageView ivwContrasena,
      @NonNull ImageView ivwInicioSesion, @NonNull LinearLayout linearLayout3,
      @NonNull LinearLayout linearLayoutContrasena, @NonNull LinearLayout lytUsuario,
      @NonNull ProgressBar progressBar, @NonNull TextView tvwInicioSesion,
      @NonNull EditText txtContrasena, @NonNull EditText txtUsuario) {
    this.rootView = rootView;
    this.ConstraintLayout = ConstraintLayout;
    this.btnContinuar = btnContinuar;
    this.imvUsuario = imvUsuario;
    this.ivwContrasena = ivwContrasena;
    this.ivwInicioSesion = ivwInicioSesion;
    this.linearLayout3 = linearLayout3;
    this.linearLayoutContrasena = linearLayoutContrasena;
    this.lytUsuario = lytUsuario;
    this.progressBar = progressBar;
    this.tvwInicioSesion = tvwInicioSesion;
    this.txtContrasena = txtContrasena;
    this.txtUsuario = txtUsuario;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout ConstraintLayout = (ConstraintLayout) rootView;

      id = R.id.btnContinuar;
      Button btnContinuar = ViewBindings.findChildViewById(rootView, id);
      if (btnContinuar == null) {
        break missingId;
      }

      id = R.id.imvUsuario;
      ImageView imvUsuario = ViewBindings.findChildViewById(rootView, id);
      if (imvUsuario == null) {
        break missingId;
      }

      id = R.id.ivwContrasena;
      ImageView ivwContrasena = ViewBindings.findChildViewById(rootView, id);
      if (ivwContrasena == null) {
        break missingId;
      }

      id = R.id.ivwInicioSesion;
      ImageView ivwInicioSesion = ViewBindings.findChildViewById(rootView, id);
      if (ivwInicioSesion == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.linearLayoutContrasena;
      LinearLayout linearLayoutContrasena = ViewBindings.findChildViewById(rootView, id);
      if (linearLayoutContrasena == null) {
        break missingId;
      }

      id = R.id.lytUsuario;
      LinearLayout lytUsuario = ViewBindings.findChildViewById(rootView, id);
      if (lytUsuario == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.tvwInicioSesion;
      TextView tvwInicioSesion = ViewBindings.findChildViewById(rootView, id);
      if (tvwInicioSesion == null) {
        break missingId;
      }

      id = R.id.txtContrasena;
      EditText txtContrasena = ViewBindings.findChildViewById(rootView, id);
      if (txtContrasena == null) {
        break missingId;
      }

      id = R.id.txtUsuario;
      EditText txtUsuario = ViewBindings.findChildViewById(rootView, id);
      if (txtUsuario == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, ConstraintLayout, btnContinuar,
          imvUsuario, ivwContrasena, ivwInicioSesion, linearLayout3, linearLayoutContrasena,
          lytUsuario, progressBar, tvwInicioSesion, txtContrasena, txtUsuario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
