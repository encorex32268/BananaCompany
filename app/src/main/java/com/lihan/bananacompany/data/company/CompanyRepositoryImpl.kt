package com.lihan.bananacompany.data.company

import com.lihan.bananacompany.data.company.local.LocalDataRepositoryImpl
import com.lihan.bananacompany.data.company.remote.DataSourceRepositoryImpl
import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor (
    private val localDataRepositoryImpl: LocalDataRepositoryImpl,
    private val dataRepositoryImpl: DataSourceRepositoryImpl
        ) : CompanyRepository{
    override suspend fun getEmployees(): Result {
        return when(val result = dataRepositoryImpl.getAllEmployee()){
            is Result.Success->{
                localDataRepositoryImpl.insert(result.data)
                result
            }
            is Result.Fail->{
                result
            }
        }
    }
}