package com.reddot.mvvmnetworkcall.features.model

import HeadlinesResponse
import android.content.Context
import com.reddot.mvvmnetworkcall.common.RequestCompleteListener
import com.reddot.mvvmnetworkcall.network.ApiService
import com.reddot.mvvmnetworkcall.network.ApiVariables
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeadlinesModelImplementation (private val context: Context): HeadlinesModel{

    override fun getHeadlines(callback: RequestCompleteListener<HeadlinesResponse>) {

        val call: Call<HeadlinesResponse> = ApiService.getClient.getHeadlines(ApiVariables.API_KEY_VALUE, "us")

        call.enqueue(object : Callback<HeadlinesResponse>{
            override fun onFailure(call: Call<HeadlinesResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!)
            }

            override fun onResponse(
                call: Call<HeadlinesResponse>,
                response: Response<HeadlinesResponse>
            ) {
                if (response.body()!=null)
                    callback.onRequestSuccess(response.body()!!)
                else
                    callback.onRequestFailed(response.message())
            }

        })
    }

}