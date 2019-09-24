package br.com.dojo.project.interactor

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.repository.NamesRepository
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.model.Gender
import br.com.dojo.project.service.model.ApiError

class NamesInteractor(private val namesRepository: NamesRepository) {

    suspend fun loadData(
        amount: Int?,
        region: String?,
        gender: Gender?
    ): AppResult<List<PersonName>, ApiError> =
        namesRepository.getNames(amount, region, gender?.name?.toLowerCase())
}