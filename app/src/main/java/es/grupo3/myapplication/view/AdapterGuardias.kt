package es.grupo3.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import es.grupo3.myapplication.R
import es.grupo3.myapplication.databinding.ItemGuardiaBinding
import es.grupo3.myapplication.model.Guardia

class AdapterGuardias(
    private val listaGuardias: List<Guardia>,
    private val id: Int,
    private val onClickGuardia: (Guardia) -> Unit,
) : RecyclerView.Adapter<AdapterGuardias.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemGuardiaBinding.bind(view)
        private val daysOfWeek: List<String> =
            listOf("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")

        fun bind(guardia: Guardia, id: Int, onClickGuardia: (Guardia) -> Unit) {
            binding.txtAula.text = "Aula: ${guardia.aula}"
            binding.txtGrupo.text = "Grupo: ${guardia.grupo}"
            binding.txtProfFalta.text = "Falta: ${guardia.profFalta.getFullName()}"
            binding.txtDia.text = "${daysOfWeek[guardia.diaSemana]} ${guardia.fecha.split('-')[2].toInt()}"

            binding.layout.setOnClickListener {
                var x = guardia
                onClickGuardia(guardia)
            }

            if (id == 0) return

            binding.txtEstado.isVisible = true
            binding.iconImageView.isVisible = false

            if (guardia.profFalta.id == id) {
                if (guardia.estado == "A") {
                    binding.txtEstado.text = "ANULADA"
                    binding.txtEstado.setBackgroundResource(R.drawable.canceled_style)

                    return
                }

                binding.txtEstado.text = "CREADA"
                binding.txtEstado.setBackgroundResource(R.drawable.accepted_style)

                return
            }

            binding.txtEstado.text = if (guardia.estado == "C") "ACEPTADA" else "REALIZADA"
            binding.txtEstado.setBackgroundResource(R.drawable.realized_style)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_guardia, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val guardia = listaGuardias[position]
        holder.bind(guardia, id) { guardia -> onClickGuardia(guardia) }
    }

    override fun getItemCount(): Int = listaGuardias.size
}