package com.lihan.bananacompany.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lihan.bananacompany.data.local.entity.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version = 1 , exportSchema = false)
@TypeConverters(
    Converters::class
)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract val employeeDao : EmployeeDao
}