package br.com.dojo.project.view.chooseParams.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.com.dojo.project.common.model.BaseModel

class ChooseParamsAppModel : BaseModel() {
    enum class State {
        LOADING, ERROR, SUCCESS
    }

    val state: MutableLiveData<State> = MutableLiveData<State>().apply { value = State.LOADING }
    val isLoadingStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.LOADING }
    val isErrorStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.ERROR }
    val isSuccessStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.SUCCESS }

    val regions: MutableLiveData<Array<String>> =
        MutableLiveData<Array<String>>().apply { value = emptyArray() }

    val amount: MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }
    val gender: MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }
    val region: MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }

    sealed class Action {
        data class OpenListNameFragment(
            val amount: Int,
            val region: String?,
            val gender: String?
        ) : Action()

        data class ShowErrorValidationMessageDialog(val messageRes: Int) : Action()

        data class ShowGenderDialog(val genderList: Array<String>) : Action()

        data class ShowRegionDialog(val regionList: Array<String>) : Action()
    }

    val action = MutableLiveData<Action>()
}