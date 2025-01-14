package com.sashi.codechallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.sashi.codechallenge.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

const val CONNECTION_TIME_OUT_IN_SEC = 60L
const val READ_TIME_OUT_IN_SEC = 60L
const val WRITE_TIME_OUT_IN_SEC = 60L

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(CONNECTION_TIME_OUT_IN_SEC, TimeUnit.SECONDS) // Connection timeout
            .readTimeout(READ_TIME_OUT_IN_SEC, TimeUnit.SECONDS)   // Read timeout
            .writeTimeout(WRITE_TIME_OUT_IN_SEC, TimeUnit.SECONDS)  // Write timeout
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttp: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

}
