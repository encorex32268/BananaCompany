package com.lihan.bananacompany.data.company

import com.lihan.bananacompany.domain.Result

interface CompanyRepository {
    suspend fun getEmployees() : Result
}