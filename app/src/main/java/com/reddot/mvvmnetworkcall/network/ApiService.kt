package com.reddot.mvvmnetworkcall.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiService {

    val getClient: ApiCallBackInterface
        get() {
            val gson = GsonBuilder().setLenient().create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(ApiVariables.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ApiVariables.READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .build()
                    chain.proceed(newRequest)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(ApiVariables.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiCallBackInterface::class.java)
        }
}