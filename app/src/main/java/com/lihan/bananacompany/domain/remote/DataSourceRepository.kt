package com.lihan.bananacompany.domain.remote

import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface DataSourceRepository {
    suspend fun getAllEmployee() : Result
}