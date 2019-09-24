package br.com.dojo.project.repository

import br.com.dojo.project.service.regionService.RegionService


class RegionRepository(private val regionService: RegionService) {

    suspend fun getRegions() = regionService.getRegions()

}