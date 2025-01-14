package com.sashi.codechallenge.di

import com.sashi.codechallenge.data.local.PrefsManager
import com.sashi.codechallenge.data.remote.ApiService
import com.sashi.codechallenge.domain.repository.LocalRepo
import com.sashi.codechallenge.domain.repository.LocalRepoImpl
import com.sashi.codechallenge.domain.repository.RemoteRepo
import com.sashi.codechallenge.domain.repository.RemoteRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLocalRepo(prefsManager: PrefsManager): LocalRepo {
        return LocalRepoImpl(prefsManager)
    }

    @Provides
    @Singleton
    fun provideRemoteRepo(apiService: ApiService): RemoteRepo {
        return RemoteRepoImpl(apiService)
    }
}