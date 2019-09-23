package br.com.dojo.project.view.nameList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dojo.project.R
import br.com.dojo.project.databinding.ListNamesFragmentBinding
import br.com.dojo.project.utils.addPaddingTop
import br.com.dojo.project.utils.fragmentBinding
import br.com.dojo.project.utils.statusBarHeightOverCard
import br.com.dojo.project.view.nameList.adapter.ListNamesAdapter
import br.com.dojo.project.view.nameList.model.ListNamesAppModel
import br.com.dojo.project.view.nameList.viewModel.ListNamesViewModel
import kotlinx.android.synthetic.main.error_view.view.*
import kotlinx.android.synthetic.main.simple_toolbar.view.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val extraAmount = "extraAmount"
private const val extraRegion = "extraRegion"
private const val extraGender = "extraGender"

class ListNamesFragment : Fragment() {

    companion object {
        const val tag: String = "ListNamesFragment"

        fun newInstance(amount: String?, region: String?, gender: String?) =
            ListNamesFragment().apply {
                arguments = Bundle().apply {
                    putString(extraAmount, amount)
                    putString(extraRegion, region)
                    putString(extraGender, gender)
                }
            }
    }

    private val binding by fragmentBinding<ListNamesFragmentBinding>(R.layout.list_names_fragment)
    private val listNamesViewModel: ListNamesViewModel by viewModel()
    private val adapter: ListNamesAdapter by lazy { ListNamesAdapter() }
    private val amount: String? by lazy { arguments?.getString(extraAmount) }
    private val region: String? by lazy { arguments?.getString(extraRegion) }
    private val gender: String? by lazy { arguments?.getString(extraGender) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ListNamesFragment.listNamesViewModel
        }

        with(binding.toolbarContainer) {
            toolbar.addPaddingTop(statusBarHeightOverCard())
            toolbar.title.text = getString(R.string.list_names_frag_title)
            toolbar.button.setOnClickListener { activity?.onBackPressed() }
        }

        binding.errorContainer.error_try.setOnClickListener { loadData() }
        configureRecyclerView()
        observeChanges()
        loadData()

        return binding.root
    }

    private fun loadData(){
        listNamesViewModel.loadData(amount, region, gender)
    }

    private fun configureRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun observeChanges() {
        listNamesViewModel.model.action.observe(viewLifecycleOwner, Observer { action ->
            when (action) {
                is ListNamesAppModel.Action.LoadData ->
                    adapter.setData(action.personNames)
            }
        })
    }
}