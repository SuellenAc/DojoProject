package br.com.dojo.project.interactor

import br.com.dojo.project.interactor.model.ValidationError
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.repository.RegionRepository

class ChooseParamsInteractor(private val regionRepository: RegionRepository) {

    fun validateAmount(amount: String?): AppResult<Int, ValidationError> {
        val amountValue = amount?.toIntOrNull() ?: 1
        return if (amountValue in 1..30) {
            AppResult.Success(amountValue)
        } else {
            AppResult.Error(ValidationError.AmountWrongRange)
        }
    }

    suspend fun getRegions() = regionRepository.getRegions()
}