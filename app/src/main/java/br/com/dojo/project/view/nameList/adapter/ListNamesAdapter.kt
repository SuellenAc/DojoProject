package br.com.dojo.project.view.nameList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dojo.project.R
import br.com.dojo.project.databinding.NameItemBinding
import br.com.dojo.project.model.PersonName

class ListNamesAdapter : RecyclerView.Adapter<ListNamesAdapter.ListNamesViewHolder>() {
    private var data: MutableList<PersonName> = mutableListOf()

    fun setData(value: List<PersonName>) {
        data.clear()
        data.addAll(value)
        notifyDataSetChanged()
    }

    fun getItem(index: Int) = data[index]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNamesViewHolder =
        ListNamesViewHolder(
            NameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListNamesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ListNamesViewHolder(private val binding: NameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(personName: PersonName) {
            binding.name.text =  binding.name.context.getString(R.string.person_name, personName.name, personName.surname)
            binding.region.text = personName.region
            binding.gender.text = personName.gender
        }
    }
}