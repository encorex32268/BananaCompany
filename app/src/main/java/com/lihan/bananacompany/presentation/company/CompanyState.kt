package com.lihan.bananacompany.presentation.company

import com.lihan.bananacompany.domain.model.Employee

data class CompanyState(
  val employees : List<Employee> = emptyList(),
  val isLoading : Boolean = false
)
