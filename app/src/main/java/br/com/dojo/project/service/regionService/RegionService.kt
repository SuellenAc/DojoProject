package br.com.dojo.project.service.regionService

import br.com.dojo.project.model.AppResult
import br.com.dojo.project.service.model.ApiError

interface RegionService {
    suspend fun getRegions(): AppResult<List<String>, ApiError>
}