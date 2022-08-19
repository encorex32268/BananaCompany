package com.lihan.bananacompany.data.company

import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee

interface CompanyRepository {
    suspend fun getEmployees() : List<Employee>
}