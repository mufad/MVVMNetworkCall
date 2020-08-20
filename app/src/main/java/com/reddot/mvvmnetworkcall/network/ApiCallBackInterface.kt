package com.reddot.mvvmnetworkcall.network

import HeadlinesResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiCallBackInterface {

    @GET(ApiVariables.API_HEADLINES)
    fun getHeadlines(@Query(ApiVariables.PARAM_API_KEY) apiKey: String,
                     @Query(ApiVariables.PARAM_COUNTRY) country: String
     ): Call<HeadlinesResponse>

}