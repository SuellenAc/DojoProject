package br.com.dojo.project.view.chooseParams.viewModel

import br.com.dojo.project.view.chooseParams.model.ChooseParamsAppModel
import br.com.dojo.project.common.viewModel.BaseViewModel

class ChooseParamsViewModel : BaseViewModel<ChooseParamsAppModel>() {

    override val model = ChooseParamsAppModel()

    fun onSearchClick() {
        model.action.postValue(
            ChooseParamsAppModel.Action.OpenListNameFragment(
                amount = model.amount.value,
                region = model.region.value,
                gender = model.gender.value
            )
        )
    }

}