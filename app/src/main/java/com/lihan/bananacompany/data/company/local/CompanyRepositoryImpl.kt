package com.lihan.bananacompany.data.company.local

import com.lihan.bananacompany.data.database.CompanyDao
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.model.toEmployee
import com.lihan.bananacompany.domain.model.toEmployeeEntity
import com.lihan.bananacompany.domain.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CompanyRepositoryImpl(
    private val dao : CompanyDao
) : CompanyRepository {
    override suspend fun insert(employee: Employee) {
        dao.insert(employee.toEmployeeEntity())
    }
    override fun getAllEmployee(): Flow<List<Employee>> {
        return dao.getAllEmployee()
            .map {
                it.map {
                    it.toEmployee() }
        }
    }
}