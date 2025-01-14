package com.sashi.codechallenge.base

import kotlinx.coroutines.flow.FlowCollector

/**
 * Created by Sashi Manandhar on 14/01/2025.
 * Senior Android Developer
 * sashimdr8@gmail.com
 **/

abstract class BaseDataStateUseCase<in Params, ReturnType : Any> {

    suspend operator fun invoke(
        params: Params,
        collector: FlowCollector<BaseDataState<ReturnType>>
    ) {
        try {
            execute(params, collector)
        } catch (e: Exception) {
            collector.emit(
                BaseDataState.Error(
                    e.message ?: "An unknown error occurred",
                    e
                )
            )
        }
    }

    protected abstract suspend fun execute(
        params: Params,
        collector: FlowCollector<BaseDataState<ReturnType>>
    )
}