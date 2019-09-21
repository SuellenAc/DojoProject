package br.com.dojo.project.common.viewModel

import androidx.lifecycle.ViewModel
import br.com.dojo.project.common.model.BaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel<T : BaseModel> : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext = job + Dispatchers.Main

    abstract val model: T

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}