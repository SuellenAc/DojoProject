package br.com.dojo.project.koin

import br.com.dojo.project.view.nameList.viewModel.ListNamesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nameListModule = module {
    viewModel { ListNamesViewModel(get()) }
}