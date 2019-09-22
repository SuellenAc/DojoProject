package br.com.dojo.project.service.regionService

interface RegionService {
    suspend fun getRegions(): List<String>
}