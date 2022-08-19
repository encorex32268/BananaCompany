package com.lihan.bananacompany.domain.repository

import com.lihan.bananacompany.domain.model.Employee
import kotlinx.coroutines.flow.Flow


interface LocalDataRepository {
    suspend fun insert(employees: List<Employee>)
    fun getAllEmployee() : Flow<List<Employee>>
}