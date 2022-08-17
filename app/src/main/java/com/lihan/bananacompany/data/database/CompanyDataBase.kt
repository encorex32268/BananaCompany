package com.lihan.bananacompany.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lihan.bananacompany.domain.model.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version = 1 , exportSchema = false)
abstract class CompanyDataBase : RoomDatabase() {
    abstract val companyDao : CompanyDao
}