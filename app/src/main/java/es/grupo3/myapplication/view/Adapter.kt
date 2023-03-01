package es.grupo3.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.grupo3.myapplication.R
import es.grupo3.myapplication.databinding.ItemGuardiaBinding
import es.grupo3.myapplication.model.Guardia

class Adapter(private val listaGuardias: List<Guardia>,
              private val onClickGuardia: (Guardia) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>()
{

    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemGuardiaBinding.bind(view)

        fun bind(guardia: Guardia, onClickDinosaurio: (Guardia) -> Unit)
        {
            binding.textViewNombreAnimal.text = "${guardia.fecha} - ${guardia.aula}"
            binding.layout.setOnClickListener { onClickDinosaurio(guardia) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_guardia, parent, false)

        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val guardia = listaGuardias[position]
        holder.bind(guardia, onClickGuardia)
    }

    override fun getItemCount(): Int = listaGuardias.size



}