package br.com.dojo.project.view.nameList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.dojo.project.R
import br.com.dojo.project.databinding.ListNamesFragmentBinding
import br.com.dojo.project.utils.fragmentBinding

class ListNamesFragment : Fragment(){

    companion object {
        val tag: String = "ListNamesFragment"

        fun newInstance() = ListNamesFragment()
    }

    private val binding by fragmentBinding<ListNamesFragmentBinding>(R.layout.list_names_fragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return binding.root
    }
}