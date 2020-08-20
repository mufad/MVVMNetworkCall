package com.reddot.mvvmnetworkcall.features.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.reddot.mvvmnetworkcall.R
import com.reddot.mvvmnetworkcall.features.model.HeadlinesModel
import com.reddot.mvvmnetworkcall.features.model.HeadlinesModelImplementation
import com.reddot.mvvmnetworkcall.features.viewmodel.NewsHeadlinesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var model: HeadlinesModel
    private lateinit var viewModel: NewsHeadlinesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVars()
        getLiveDataListener()
    }

    private fun initVars(){

        model = HeadlinesModelImplementation(applicationContext)
        viewModel = ViewModelProvider(this).get(NewsHeadlinesViewModel::class.java)
        viewModel.getHeadlines(model)
    }

    private fun getLiveDataListener(){
        viewModel.headlinesLiveData.observe(this, Observer { headlinesData ->
            Log.d("HERE", headlinesData.status)
        })

        viewModel.headlinesDataError.observe(this, Observer { error ->
            Log.d("HERE", error)
        })
    }
}