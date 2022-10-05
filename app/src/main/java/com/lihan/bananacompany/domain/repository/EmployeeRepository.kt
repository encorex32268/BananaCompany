package com.lihan.bananacompany.domain.repository

import com.lihan.bananacompany.core.util.Resource
import com.lihan.bananacompany.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    fun getEmployee(): Flow<Resource<List<Employee>>>
}