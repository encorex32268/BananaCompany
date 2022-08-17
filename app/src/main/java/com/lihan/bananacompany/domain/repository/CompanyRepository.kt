package com.lihan.bananacompany.domain.repository

import com.lihan.bananacompany.domain.model.Employee
import kotlinx.coroutines.flow.Flow


interface CompanyRepository {
    suspend fun insert(employee: Employee)
    fun getAllEmployee() : Flow<List<Employee>>
}