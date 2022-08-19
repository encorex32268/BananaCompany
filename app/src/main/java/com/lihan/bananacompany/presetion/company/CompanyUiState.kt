package com.lihan.bananacompany.presetion.company

import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee

sealed class CompanyUiState{
    object OnLoading : CompanyUiState()
    data class Fail(val message : String , val data : List<Employee> = emptyList()): CompanyUiState()
    data class Success(val data : List<Employee>) : CompanyUiState()
}
