package com.lihan.bananacompany.data.company.remote

import com.lihan.bananacompany.BuildConfig
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.remote.DataSourceRepository
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSourceRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : DataSourceRepository {
    override suspend fun getAllEmployee(): List<Employee> {
        return httpClient.get<List<Employee>>(BuildConfig.BASE_URL)
    }
}