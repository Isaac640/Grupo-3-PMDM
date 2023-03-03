// Generated by view binder compiler. Do not edit!
package es.grupo3.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import es.grupo3.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGuardiasBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar progressBarCarga;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView txtNoResults;

  private FragmentGuardiasBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar progressBarCarga, @NonNull RecyclerView recyclerView,
      @NonNull TextView txtNoResults) {
    this.rootView = rootView;
    this.progressBarCarga = progressBarCarga;
    this.recyclerView = recyclerView;
    this.txtNoResults = txtNoResults;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGuardiasBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGuardiasBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_guardias, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGuardiasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.progressBarCarga;
      ProgressBar progressBarCarga = ViewBindings.findChildViewById(rootView, id);
      if (progressBarCarga == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.txtNoResults;
      TextView txtNoResults = ViewBindings.findChildViewById(rootView, id);
      if (txtNoResults == null) {
        break missingId;
      }

      return new FragmentGuardiasBinding((ConstraintLayout) rootView, progressBarCarga,
          recyclerView, txtNoResults);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}