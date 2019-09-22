package br.com.dojo.project.view.nameList.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dojo.project.model.PersonName

class ListNamesAdapter : RecyclerView.Adapter<ListNamesAdapter.ListNamesViewHolder>(){
    private var data: MutableList<PersonName> = mutableListOf()

    fun setData(value: List<PersonName>){
        data.clear()
        data.addAll(value)
        notifyDataSetChanged()
    }

    fun getItem(index : Int) = data[index]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNamesViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListNamesViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ListNamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(){}
    }
}