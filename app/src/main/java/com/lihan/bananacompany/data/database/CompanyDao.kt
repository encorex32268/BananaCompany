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
    suspend fun insert(employeeEntities: List<EmployeeEntity>)

    @Query("select * from EmployeeEntity ")
    suspend fun getAllEmployee() : List<EmployeeEntity>

}