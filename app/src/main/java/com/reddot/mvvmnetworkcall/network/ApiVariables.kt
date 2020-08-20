package com.reddot.mvvmnetworkcall.network

class ApiVariables {

    companion object {
        var READ_TIMEOUT: Long = 60
        var CONNECTION_TIMEOUT: Long = 60

        const val BASE_URL = "https://newsapi.org/v2/"

        const val API_KEY_VALUE = "51b882b292374f1d834b6c5677ea7568"

        const val API_HEADLINES = "top-headlines"
        const val PARAM_API_KEY="apiKey"
        const val PARAM_COUNTRY="country"



    }
}