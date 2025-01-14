package com.sashi.codechallenge.di

import android.content.Context
import com.sashi.codechallenge.data.local.PrefsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun providePrefsManager(@ApplicationContext context: Context): PrefsManager {
        return PrefsManager(context)
    }


}