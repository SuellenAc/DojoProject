package br.com.dojo.project.view.chooseParams.model

import androidx.lifecycle.MutableLiveData
import br.com.dojo.project.common.model.BaseModel

class ChooseParamsAppModel : BaseModel() {

    val amount : MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }
    val gender : MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }
    val region : MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }

    sealed class Action {
        data class OpenListNameFragment(
            val amount: String?,
            val region: String?,
            val gender: String?
        ) : Action()
    }

    val action = MutableLiveData<Action>()
}