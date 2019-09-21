package br.com.dojo.project.view.chooseParams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.dojo.project.R
import br.com.dojo.project.databinding.ChooseParamsFragmentBinding
import br.com.dojo.project.utils.fragmentBinding

class ChooseParamsFragment : Fragment() {

    companion object {
        val tag: String = "ChooseParamsFragment"

        fun newInstance() = ChooseParamsFragment()
    }

    private val binding by fragmentBinding<ChooseParamsFragmentBinding>(
        R.layout.choose_params_fragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return binding.root
    }
}