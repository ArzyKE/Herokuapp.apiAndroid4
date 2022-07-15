package com.example.herokuappapiandroid4.data.remote

import com.example.herokuappapiandroid4.data.apiservices.PeopleApiServices
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun providePeopleApiService() = provideRetrofit.create(PeopleApiServices::class.java)
}