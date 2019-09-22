package br.com.dojo.project.koin

import br.com.dojo.project.interactor.NamesInteractor
import br.com.dojo.project.interactor.RegionInteractor
import org.koin.dsl.module

val interactorModule = module {
    factory { NamesInteractor(get()) }
    factory { RegionInteractor(get()) }
}