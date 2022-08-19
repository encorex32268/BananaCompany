package com.lihan.bananacompany.data.company.local

import com.lihan.bananacompany.data.database.CompanyDao
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.model.toEmployee
import com.lihan.bananacompany.domain.model.toEmployeeEntity
import com.lihan.bananacompany.domain.repository.LocalDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(
    private val dao : CompanyDao
) : LocalDataRepository {
    override suspend fun insert(employees: List<Employee>) {
        dao.insert(employees.map {
            it.toEmployeeEntity()
        })
    }
    override fun getAllEmployee(): Flow<List<Employee>> {
        return dao.getAllEmployee()
            .map {
                it.map {
                    it.toEmployee() }
        }
    }
}