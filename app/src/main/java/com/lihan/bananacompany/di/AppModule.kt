package com.lihan.bananacompany.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.lihan.bananacompany.data.company.CompanyRepository
import com.lihan.bananacompany.data.company.CompanyRepositoryImpl
import com.lihan.bananacompany.data.company.local.LocalDataRepositoryImpl
import com.lihan.bananacompany.data.company.remote.DataSourceRepositoryImpl
import com.lihan.bananacompany.data.database.CompanyDao
import com.lihan.bananacompany.data.database.CompanyDataBase
import com.lihan.bananacompany.domain.remote.DataSourceRepository
import com.lihan.bananacompany.domain.repository.LocalDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
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
    fun providesCompanyDao(companyDataBase: CompanyDataBase) = companyDataBase.companyDao


    @Provides
    @Singleton
    fun providesHttpClient() : HttpClient{
        return HttpClient(Android) {
            engine {
                connectTimeout =30_000
                socketTimeout = 30_000
            }
            install(Logging){
                logger = object : Logger{
                    override fun log(message: String) {
//                        Log.d("TAG", "log: ${message}")
                    }

                }
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }.also {
            it.sendPipeline.intercept(HttpSendPipeline.State){
//                context.headers.append("appName", BuildConfig.APP_NAME)
            }
        }
    }






}