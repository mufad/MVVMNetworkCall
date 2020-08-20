package com.reddot.mvvmnetworkcall.features.viewmodel

import HeadlinesResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reddot.mvvmnetworkcall.common.RequestCompleteListener
import com.reddot.mvvmnetworkcall.features.model.HeadlinesModel

class NewsHeadlinesViewModel : ViewModel(){

    val headlinesLiveData = MutableLiveData<HeadlinesResponse>()
    val  headlinesDataError= MutableLiveData<String>()

    fun getHeadlines(model: HeadlinesModel){
        model.getHeadlines(object :
            RequestCompleteListener<HeadlinesResponse> {
            override fun onRequestSuccess(data: HeadlinesResponse) {
               headlinesLiveData.postValue(data)
            }

            override fun onRequestFailed(errorMessage: String) {
                headlinesDataError.postValue(errorMessage)
            }

        })
    }
}