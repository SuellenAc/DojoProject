package br.com.dojo.project.view.nameList.viewModel

import br.com.dojo.project.common.viewModel.BaseViewModel
import br.com.dojo.project.view.nameList.model.ListNamesAppModel

class ListNamesViewModel : BaseViewModel<ListNamesAppModel>() {
    override val model: ListNamesAppModel = ListNamesAppModel()
}