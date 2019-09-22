package br.com.dojo.project.service.namesService

import br.com.dojo.project.model.PersonName

interface NamesService {
    suspend fun getNames(amount: String?, region: String?, gender: String?): List<PersonName>
}