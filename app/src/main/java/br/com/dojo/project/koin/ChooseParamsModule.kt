package br.com.dojo.project.koin

import br.com.dojo.project.view.chooseParams.viewModel.ChooseParamsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chooseParamsModule = module {
    viewModel { ChooseParamsViewModel(get()) }
}