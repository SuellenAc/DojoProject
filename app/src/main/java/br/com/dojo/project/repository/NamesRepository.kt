package br.com.dojo.project.repository

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.service.model.ApiError
import br.com.dojo.project.service.namesService.NamesService

class NamesRepository(private val namesService: NamesService) {

    suspend fun getNames(
        amount: Int?,
        region: String?,
        gender: String?
    ): AppResult<List<PersonName>, ApiError> = namesService.getNames(amount, region, gender)

}