package com.target.targetcasestudy.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.data.ProductList
import com.target.targetcasestudy.service.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {
    var servicesLiveData: MutableLiveData<ProductList>? = null

    fun getProducts(): LiveData<ProductList>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }
}