package br.com.dojo.project.view.chooseParams.viewModel

import br.com.dojo.project.R
import br.com.dojo.project.view.chooseParams.model.ChooseParamsAppModel
import br.com.dojo.project.common.viewModel.BaseViewModel
import br.com.dojo.project.interactor.ChooseParamsInteractor
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.model.Gender
import kotlinx.coroutines.launch

class ChooseParamsViewModel(private val chooseParamsInteractor: ChooseParamsInteractor) :
    BaseViewModel<ChooseParamsAppModel>() {

    override val model = ChooseParamsAppModel()

    fun getRegions() {
        launch {
            model.state.postValue(ChooseParamsAppModel.State.LOADING)
            when (val result = chooseParamsInteractor.getRegions()) {
                is AppResult.Success -> {
                    model.state.postValue(ChooseParamsAppModel.State.SUCCESS)
                    model.regions.postValue(result.value.toTypedArray())
                }
                is AppResult.Error -> model.state.postValue(ChooseParamsAppModel.State.ERROR)
            }
        }
    }

    fun onGenderSelectionClick() {
        model.action.postValue(
            ChooseParamsAppModel.Action.ShowGenderDialog(
                arrayOf(
                    Gender.FEMALE.name,
                    Gender.MALE.name
                )
            )
        )
    }

    fun onRegionSelectionClick() {
        if (model.state.value == ChooseParamsAppModel.State.SUCCESS) {
            model.action.postValue(
                ChooseParamsAppModel.Action.ShowRegionDialog(model.regions.value ?: emptyArray())
            )
        }
    }

    fun onGenderSelected(gender: String?) {
        model.gender.postValue(gender)
    }

    fun onRegionSelected(region: String?) {
        model.region.postValue(region)
    }

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