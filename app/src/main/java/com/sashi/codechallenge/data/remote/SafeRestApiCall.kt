package com.sashi.codechallenge.data.remote

import com.sashi.codechallenge.base.BaseDataState
import com.sashi.codechallenge.base.DataStrings.SOMETHING_WENT_WRONG
import org.json.JSONObject
import retrofit2.Response

/**
 * Created by Sashi Manandhar on 14/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

suspend fun <T> safeRestApiCall(apiCall: suspend () -> Response<T>): BaseDataState<T> {

    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            BaseDataState.Success(response.body()!!)
        } else {
            var msg = SOMETHING_WENT_WRONG
            response.errorBody()?.string()?.let {
                val jsonObject = JSONObject(it)
                msg = jsonObject.getString("error")
            }
            BaseDataState.Error(msg, Throwable(msg))
        }
    } catch (e: Exception) {
        BaseDataState.Error(SOMETHING_WENT_WRONG, e)
    }
}

object HttpStatusCodes {
    const val BAD_REQUEST = 400
    const val NOT_FOUND = 404
    const val FORBIDDEN = 403
    const val INTERNAL_SERVER_ERROR = 500
}