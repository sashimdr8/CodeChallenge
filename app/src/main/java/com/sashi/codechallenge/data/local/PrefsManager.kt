package com.sashi.codechallenge.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

@Singleton
class PrefsManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        const val PREFS_NAME = "houzzCodeChallengePrefs"
        const val NAME = "name"
    }

    private val prefs: SharedPreferences = context
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveName(name: String) {
        prefs.edit().putString(NAME, name).apply()
    }

    fun getName() : String? {
        return prefs.getString(NAME, null)
    }
}