package br.com.dojo.project.service.namesService

import br.com.dojo.project.model.PersonName
import br.com.dojo.project.model.AppResult
import br.com.dojo.project.model.Gender
import br.com.dojo.project.service.model.ApiError

interface NamesService {
    suspend fun getNames(amount: Int?, region: String?, gender: String?): AppResult<List<PersonName>, ApiError>
}