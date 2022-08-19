package com.lihan.bananacompany.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.lihan.bananacompany.domain.model.EmployeeEntity
import com.lihan.bananacompany.domain.model.FriendConverter
import com.lihan.bananacompany.domain.model.TagsConverter

@Database(entities = [EmployeeEntity::class], version = 1 , exportSchema = false)
@TypeConverters(FriendConverter::class, TagsConverter::class)
abstract class CompanyDataBase : RoomDatabase() {
    abstract val companyDao : CompanyDao
}