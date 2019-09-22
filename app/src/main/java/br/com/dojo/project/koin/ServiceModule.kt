package br.com.dojo.project.koin

import br.com.dojo.project.service.WebService
import br.com.dojo.project.service.namesService.AppNamesService
import br.com.dojo.project.service.namesService.NamesService
import br.com.dojo.project.service.regionService.AppRegionService
import br.com.dojo.project.service.regionService.RegionService
import org.koin.dsl.module

val serviceModule = module {
    single<NamesService> { AppNamesService(get()) }
    single<RegionService> { AppRegionService(get()) }
    single { WebService() }
}