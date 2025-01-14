package com.sashi.codechallenge.domain.repository

import com.sashi.codechallenge.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Sashi Manandhar on 12/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

interface RemoteRepo {
}

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteRepo {
}