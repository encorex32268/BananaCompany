package com.lihan.bananacompany.data.company

import android.util.Log
import com.lihan.bananacompany.data.company.local.LocalDataRepositoryImpl
import com.lihan.bananacompany.data.company.remote.DataSourceRepositoryImpl
import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor (
    private val localDataRepositoryImpl: LocalDataRepositoryImpl,
    private val dataRepositoryImpl: DataSourceRepositoryImpl
        ) : CompanyRepository{
    override suspend fun getEmployees(): List<Employee> {
        val localData = localDataRepositoryImpl.getAllEmployee()
        return localData.ifEmpty {
            when (val result = dataRepositoryImpl.getAllEmployee()) {
                is Result.Success -> {
                    result.data
                }
                is Result.Fail -> {
                    result.data
                }
            }
        }
    }
}