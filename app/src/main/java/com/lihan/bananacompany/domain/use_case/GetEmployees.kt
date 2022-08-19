package com.lihan.bananacompany.domain.use_case

import com.lihan.bananacompany.data.company.CompanyRepository
import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee
import javax.inject.Inject

class GetEmployees @Inject constructor(
    private val companyRepository: CompanyRepository
){
    suspend operator fun invoke(): Result {
        return companyRepository.getEmployees()
    }

}