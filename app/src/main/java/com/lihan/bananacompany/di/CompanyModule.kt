package com.lihan.bananacompany.di

import com.lihan.bananacompany.data.company.CompanyRepository
import com.lihan.bananacompany.data.company.CompanyRepositoryImpl
import com.lihan.bananacompany.data.company.local.LocalDataRepositoryImpl
import com.lihan.bananacompany.data.company.remote.DataSourceRepositoryImpl
import com.lihan.bananacompany.domain.remote.DataSourceRepository
import com.lihan.bananacompany.domain.repository.LocalDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object CompanyModule {

    @Provides
    @Singleton
    fun providesDataSourceRepository(dataSourceRepositoryImpl: DataSourceRepositoryImpl) : DataSourceRepository {
        return dataSourceRepositoryImpl
    }

    @Provides
    @Singleton
    fun providesLocalDataRepository(localDataRepositoryImpl: LocalDataRepositoryImpl) : LocalDataRepository {
        return localDataRepositoryImpl
    }

    @Provides
    @Singleton
    fun providesCompanyRepository(companyRepositoryImpl: CompanyRepositoryImpl) : CompanyRepository {
        return companyRepositoryImpl
    }
}