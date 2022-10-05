package com.lihan.bananacompany.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.lihan.bananacompany.data.local.Converters
import com.lihan.bananacompany.data.local.EmployeeDao
import com.lihan.bananacompany.data.local.EmployeeDatabase
import com.lihan.bananacompany.data.repository.EmployeeRepositoryImpl
import com.lihan.bananacompany.data.util.GsonParser
import com.lihan.bananacompany.domain.repository.EmployeeRepository
import com.lihan.bananacompany.domain.use_case.GetEmployees
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
    fun providesCompanyDatabase(@ApplicationContext context : Context) : EmployeeDatabase {
        return Room.databaseBuilder(
            context,
            EmployeeDatabase::class.java,
            "company_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun providesEmployeeDao(db: EmployeeDatabase) : EmployeeDao{
       return db.employeeDao
    }


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



    @Provides
    @Singleton
    fun providesEmployeeRepository(
        httpClient: HttpClient,
        dao: EmployeeDao
    ) : EmployeeRepository{
        return EmployeeRepositoryImpl(
            httpClient = httpClient,
            dao = dao
        )
    }

    @Provides
    @Singleton
    fun providesGetEmployeesUseCase(employeeRepository: EmployeeRepository) : GetEmployees {
        return GetEmployees(employeeRepository = employeeRepository)
    }







}