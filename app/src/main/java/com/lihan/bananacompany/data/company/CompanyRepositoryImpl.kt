package com.lihan.bananacompany.data.company

import com.lihan.bananacompany.data.company.local.LocalDataRepositoryImpl
import com.lihan.bananacompany.data.company.remote.DataSourceRepositoryImpl
import com.lihan.bananacompany.domain.model.Employee
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor (
    private val localDataRepositoryImpl: LocalDataRepositoryImpl,
    private val dataRepositoryImpl: DataSourceRepositoryImpl
        ) : CompanyRepository{
    override suspend fun getEmployees(): List<Employee> {
        val data = dataRepositoryImpl.getAllEmployee()
        return if (data.isEmpty()){
            emptyList()
        }else{
            localDataRepositoryImpl.insert(data)
            data
        }
    }
}