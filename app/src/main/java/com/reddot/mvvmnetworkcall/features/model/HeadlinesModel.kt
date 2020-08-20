package com.reddot.mvvmnetworkcall.features.model

import HeadlinesResponse
import com.reddot.mvvmnetworkcall.common.RequestCompleteListener

interface HeadlinesModel {
    fun getHeadlines(callback: RequestCompleteListener<HeadlinesResponse>)
}