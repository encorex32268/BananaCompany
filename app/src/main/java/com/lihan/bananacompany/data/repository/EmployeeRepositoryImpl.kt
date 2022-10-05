package com.lihan.bananacompany.data.repository

import com.lihan.bananacompany.core.util.Resource
import com.lihan.bananacompany.data.local.EmployeeDao
import com.lihan.bananacompany.data.remote.dto.EmployeeDto
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.repository.EmployeeRepository
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.net.HttpRetryException

class EmployeeRepositoryImpl(
    private val httpClient: HttpClient,
    private val dao : EmployeeDao
)  : EmployeeRepository{

    override fun getEmployee(): Flow<Resource<List<Employee>>> = flow {
        emit(Resource.Loading())
        val employees = dao.getAllEmployee().map { it.toEmployee() }
        emit(Resource.Loading(data = employees))
        try {
            val remoteEmployee = httpClient.get<List<EmployeeDto>>(
                urlString = "https://run.mocky.io/v3/7e83c8ed-ba75-4036-91b2-05bae5fb4cdb"
            )
            dao.deleteEmployee()
            dao.insert(remoteEmployee.map { it.toEmployeeEntity() })
        } catch (e : HttpRetryException){
            emit(Resource.Error(
                message = "Http Error",
                data = employees
            ))
        } catch (e : IOException){
            emit(Resource.Error(
                message = "Check your Internet connection",
                data = employees
            ))
        }
        val newEmployee = dao.getAllEmployee().map { it.toEmployee() }
        emit(Resource.Success(newEmployee))

    }

}