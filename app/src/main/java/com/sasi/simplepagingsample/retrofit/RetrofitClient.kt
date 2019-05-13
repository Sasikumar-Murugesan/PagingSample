package com.sasi.simplepagingsample.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "https://api.stackexchange.com/2.2/"
    var instance: Retrofit? = null
    fun create(): Api {
        return createRetrofitInstance().create(Api::class.java)
    }
    fun createRetrofitInstance(): Retrofit {
        synchronized(this) {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create()
                    )
                    .addConverterFactory(
                        GsonConverterFactory.create()
                    )
                    .baseUrl(BASE_URL)
                    .build()
                return instance as Retrofit
            }
        }

        return instance as Retrofit
    }
}

