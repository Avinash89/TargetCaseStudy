package com.example.samplecard.retrofit

import com.target.targetcasestudy.data.ProductList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("deals")
    fun getServices(): Call<ProductList>

}