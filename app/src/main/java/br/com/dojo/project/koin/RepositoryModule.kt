package br.com.dojo.project.koin

import br.com.dojo.project.repository.NamesRepository
import br.com.dojo.project.repository.RegionRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { NamesRepository(get()) }
    single { RegionRepository(get()) }
}