package com.lihan.bananacompany.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lihan.bananacompany.domain.model.EmployeeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Query("SELECT　* from EmployeeEntity")
    fun getAllEmployee() : Flow<List<EmployeeEntity>>

}