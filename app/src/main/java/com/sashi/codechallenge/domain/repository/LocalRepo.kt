package com.sashi.codechallenge.domain.repository

import com.sashi.codechallenge.data.local.PrefsManager
import javax.inject.Inject

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

interface LocalRepo {
    suspend fun saveName(name: String)
}
class LocalRepoImpl @Inject constructor(
    private val prefsManager: PrefsManager
) : LocalRepo {
    override suspend fun saveName(name: String) {
        prefsManager.saveName(name)
    }
}