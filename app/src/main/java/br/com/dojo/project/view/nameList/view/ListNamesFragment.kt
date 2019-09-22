package br.com.dojo.project.view.nameList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.dojo.project.R
import br.com.dojo.project.databinding.ListNamesFragmentBinding
import br.com.dojo.project.utils.addPaddingTop
import br.com.dojo.project.utils.fragmentBinding
import br.com.dojo.project.utils.statusBarHeightOverCard
import br.com.dojo.project.view.nameList.viewModel.ListNamesViewModel
import kotlinx.android.synthetic.main.simple_toolbar.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListNamesFragment : Fragment(){

    companion object {
        const val tag: String = "ListNamesFragment"

        fun newInstance() = ListNamesFragment()
    }

    private val binding by fragmentBinding<ListNamesFragmentBinding>(R.layout.list_names_fragment)

    private val listNamesViewModel: ListNamesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ListNamesFragment.listNamesViewModel
        }
        with(binding.toolbarContainer) {
            toolbar.addPaddingTop(statusBarHeightOverCard())
            toolbar.title.text = getString(R.string.list_names_frag_title)
        }
        observeChanges()
        return binding.root
    }

    private fun observeChanges() {
//        listNamesViewModel.model.action.observe(viewLifecycleOwner, Observer { action ->
//            when (action) {
//                is ChooseParamsAppModel.Action.OpenListNameFragment ->
//                    activity?.addFragment(
//                        newInstance(),
//                        ListNamesFragment.tag
//                    )
//            }
//        })
    }
}