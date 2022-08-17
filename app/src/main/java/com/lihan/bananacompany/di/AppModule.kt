package com.lihan.bananacompany.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lihan.bananacompany.data.company.local.CompanyRepositoryImpl
import com.lihan.bananacompany.data.database.CompanyDataBase
import com.lihan.bananacompany.domain.repository.CompanyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesCompanyDatabase(@ApplicationContext context : Context) : CompanyDataBase{
        return Room.databaseBuilder(
            context,
            CompanyDataBase::class.java,
            "company_db"
        ).build()
    }


    @Provides
    @Singleton
    fun providesCompanyRepository(db : CompanyDataBase) : CompanyRepository{
        return CompanyRepositoryImpl(db.companyDao)
    }

}