package br.com.dojo.project.view.chooseParams.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.dojo.project.R
import br.com.dojo.project.view.chooseParams.viewModel.ChooseParamsViewModel
import br.com.dojo.project.databinding.ChooseParamsFragmentBinding
import br.com.dojo.project.utils.addFragment
import br.com.dojo.project.utils.addPaddingTop
import br.com.dojo.project.utils.fragmentBinding
import br.com.dojo.project.utils.statusBarHeightOverCard
import br.com.dojo.project.view.chooseParams.model.ChooseParamsAppModel
import br.com.dojo.project.view.nameList.view.ListNamesFragment
import kotlinx.android.synthetic.main.simple_toolbar.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ChooseParamsFragment : Fragment() {

    companion object {
        const val tag: String = "ChooseParamsFragment"

        fun newInstance() = ChooseParamsFragment()
    }

    private val binding by fragmentBinding<ChooseParamsFragmentBinding>(R.layout.choose_params_fragment)

    private val chooseParamsViewModel: ChooseParamsViewModel by viewModel()

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ChooseParamsFragment.chooseParamsViewModel
        }
        with(binding.toolbarContainer) {
            toolbar.addPaddingTop(statusBarHeightOverCard())
            toolbar.title.text = getString(R.string.choose_params_frag_title)
            toolbar.button.visibility = View.GONE
        }
        observeChanges()
        return binding.root
    }

    private fun observeChanges() {
        chooseParamsViewModel.model.action.observe(viewLifecycleOwner, Observer { action ->
            when (action) {
                is ChooseParamsAppModel.Action.OpenListNameFragment ->
                    activity?.addFragment(
                        ListNamesFragment.newInstance(
                            amount = action.amount,
                            region = action.region,
                            gender = action.gender
                        ),
                        ListNamesFragment.tag
                    )
            }
        })
    }
}