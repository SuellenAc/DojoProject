package br.com.dojo.project.view.chooseParams.viewModel

import br.com.dojo.project.R
import br.com.dojo.project.view.chooseParams.model.ChooseParamsAppModel
import br.com.dojo.project.common.viewModel.BaseViewModel
import br.com.dojo.project.interactor.ChooseParamsInteractor
import br.com.dojo.project.model.AppResult

class ChooseParamsViewModel(private val chooseParamsInteractor: ChooseParamsInteractor) :
    BaseViewModel<ChooseParamsAppModel>() {

    override val model = ChooseParamsAppModel()

    fun onSearchClick() {

        when (val result = chooseParamsInteractor.validateAmount(model.amount.value)) {
            is AppResult.Success -> {
                model.action.postValue(
                    ChooseParamsAppModel.Action.OpenListNameFragment(
                        amount = result.value,
                        region = model.region.value,
                        gender = model.gender.value
                    )
                )
            }
            is AppResult.Error -> {
                model.action.postValue(
                    ChooseParamsAppModel.Action.ShowErrorValidationMessageDialog(
                        R.string.amount_error_message
                    )
                )
            }
        }

    }

}