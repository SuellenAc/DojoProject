package br.com.dojo.project.interactor

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.repository.NamesRepository
import br.com.dojo.project.repository.model.AppResult

class NamesInteractor(private val namesRepository: NamesRepository) {

    suspend fun loadData(
        amount: String?,
        region: String?,
        gender: String?
    ): AppResult<List<PersonName>, Exception> =
        AppResult.Success(namesRepository.getNames(amount, region, gender))
}