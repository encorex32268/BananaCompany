package com.lihan.bananacompany.data.local

import androidx.room.*
import com.lihan.bananacompany.data.local.entity.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employeeEntities: List<EmployeeEntity>)

    @Query("select * from EmployeeEntity ")
    suspend fun getAllEmployee() : List<EmployeeEntity>

    @Query("DELETE FROM employeeentity ")
    suspend fun deleteEmployee()

}