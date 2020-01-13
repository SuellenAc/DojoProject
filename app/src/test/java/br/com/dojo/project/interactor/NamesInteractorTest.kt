package br.com.dojo.project.interactor

import br.com.dojo.project.model.AppResult
import br.com.dojo.project.repository.NamesRepository
import br.com.dojo.project.service.model.ApiError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.ArgumentMatchers.any

class NamesInteractorTest {

    private val namesRepository: NamesRepository = mockk()

    private val interactor: NamesInteractor by lazy { NamesInteractor(namesRepository) }

    @Test
    fun loadData_callFunction() = runBlocking {
        coEvery { namesRepository.getNames(any(), any(), any()) }  returns AppResult.Error(ApiError(500, "Error"))

        interactor.loadData(any(), any(), any())

        coVerify(exactly = 1) { namesRepository.getNames(any(), any(), any()) }
    }

}