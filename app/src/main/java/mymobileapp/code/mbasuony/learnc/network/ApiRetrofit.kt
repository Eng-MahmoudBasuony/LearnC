package mymobileapp.code.mbasuony.learnc.network

import mymobileapp.code.mbasuony.learnc.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiRetrofit
{

    @GET("index/")
    fun getData():Call<ArrayList<Data>>

}