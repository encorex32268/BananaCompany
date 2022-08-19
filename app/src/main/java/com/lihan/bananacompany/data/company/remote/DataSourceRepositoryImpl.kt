package com.lihan.bananacompany.data.company.remote

import com.lihan.bananacompany.BuildConfig
import com.lihan.bananacompany.data.database.CompanyDao
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.model.toEmployee
import com.lihan.bananacompany.domain.model.toEmployeeEntity
import com.lihan.bananacompany.domain.remote.DataSourceRepository
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataSourceRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
    ) : DataSourceRepository {
    override suspend fun getAllEmployee(): List<Employee> {
       return httpClient
            .get<List<Employee>>("https://run.mocky.io/v3/7e83c8ed-ba75-4036-91b2-05bae5fb4cdb")
    }
}