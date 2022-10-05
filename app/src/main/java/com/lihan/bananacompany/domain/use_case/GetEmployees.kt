package com.lihan.bananacompany.domain.use_case


import com.lihan.bananacompany.core.util.Resource
import com.lihan.bananacompany.domain.model.Employee
import com.lihan.bananacompany.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow


class GetEmployees(
    private val employeeRepository: EmployeeRepository
){
    suspend operator fun invoke(): Flow<Resource<List<Employee>>> {
        return employeeRepository.getEmployee()
    }

}