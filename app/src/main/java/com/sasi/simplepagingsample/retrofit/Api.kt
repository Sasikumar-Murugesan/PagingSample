package com.sasi.simplepagingsample.retrofit

import com.sasi.simplepagingsample.model.UserItem
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    fun getUsersList(@Query("page")page:Int,@Query("pagesize")pagesize:Int,@Query("site")site:String="stackoverflow") :  Observable<Response<UserItem>>
}