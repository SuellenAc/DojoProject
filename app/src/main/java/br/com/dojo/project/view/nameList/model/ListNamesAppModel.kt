package br.com.dojo.project.view.nameList.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.com.dojo.project.common.model.BaseModel
import br.com.dojo.project.model.PersonName

class ListNamesAppModel : BaseModel() {

    enum class State {
        LOADING, ERROR, SUCCESS
    }

    sealed class Action {
        data class LoadData(
            val personNames: List<PersonName>
        ) : Action()
    }

    val action = MutableLiveData<Action>()

    val state: MutableLiveData<State> = MutableLiveData<State>().apply { value = State.LOADING }
    val isLoadingStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.LOADING }
    val isErrorStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.ERROR }
    val isSuccessStateVisible: LiveData<Boolean> = Transformations.map(state) { it == State.SUCCESS }
}