package com.lihan.bananacompany.domain

import com.lihan.bananacompany.domain.model.Employee

sealed class Result{
    data class Fail(val message : String , val data : List<Employee> = emptyList()):Result()
    data class Success(val data : List<Employee>) : Result()
}

