package br.com.dojo.project.view.nameList.viewModel

import br.com.dojo.project.common.viewModel.BaseViewModel
import br.com.dojo.project.interactor.NamesInteractor
import br.com.dojo.project.repository.model.AppResult
import br.com.dojo.project.view.nameList.model.ListNamesAppModel
import kotlinx.coroutines.launch

class ListNamesViewModel(private val namesInteractor: NamesInteractor) :
    BaseViewModel<ListNamesAppModel>() {
    override val model: ListNamesAppModel = ListNamesAppModel()

    fun loadData(amount: String?, region: String?, gender: String?) {
        launch {
            model.state.postValue(ListNamesAppModel.State.LOADING)
            when (val result = namesInteractor.loadData(amount, region, gender)) {
                is AppResult.Success -> {
                    model.state.postValue(ListNamesAppModel.State.SUCCESS)
                    model.action.postValue(ListNamesAppModel.Action.LoadData(result.value))
                }
                is AppResult.Error -> {
                    model.state.postValue(ListNamesAppModel.State.ERROR)
                }
            }
        }
    }
}