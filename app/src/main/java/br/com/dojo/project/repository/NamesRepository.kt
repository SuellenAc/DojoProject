package br.com.dojo.project.repository

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.repository.model.AppResult
import br.com.dojo.project.service.namesService.NamesService

class NamesRepository(private val namesService: NamesService) {

    suspend fun getNames(
        amount: String?,
        region: String?,
        gender: String?
    ): AppResult<List<PersonName>, Exception> =
        try {
            AppResult.Success(namesService.getNames(amount, region, gender))
        } catch (exception: Exception) {
            AppResult.Error(exception)
        }

}