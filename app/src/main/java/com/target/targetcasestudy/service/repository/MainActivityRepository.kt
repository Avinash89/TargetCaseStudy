package com.target.targetcasestudy.service.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.samplecard.retrofit.RetrofitClient
import com.target.targetcasestudy.data.ProductList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ProductList>()
    private var context: Context? = null
//    private var db: AppDb? = null
    fun getServicesApiCall(): MutableLiveData<ProductList> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<ProductList> {
            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ProductList>,
                response: Response<ProductList>
            ) {
                val data = response.body()
                if (data != null) {
//                    val msg = data.results
                    serviceSetterGetter.value = data
//                        UserResponseList(
//                            data.info,
//                            msg
//                        )
                }
            }
        })

        return serviceSetterGetter
    }

//    fun insertData(
//        context: Context,
//        udid: String,
//        username: String,
//        imageUrl: String,
//        status: Boolean
//    ) {
//
//        this.context = context
//        val todo = UserEntity(udid, username, imageUrl, status)
//        if (db == null) {
//            db = Room.databaseBuilder(context, AppDb::class.java, "UserDB").build()
//        }
//        Thread {
//            db!!.bookDao().saveBooks(todo)
//            //fetch Records
//            db!!.bookDao().getAllBooks().forEach()
//            {
//                Log.i("Fetch Records", "Id:  : ${it.id}")
//                Log.i("Fetch Records", "Name:  : ${it.status}")
//            }
//        }.start()
//    }

}