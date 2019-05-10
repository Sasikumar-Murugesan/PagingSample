package com.sasi.simplepagingsample.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.sasi.simplepagingsample.model.UserItem
import com.sasi.simplepagingsample.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class UserListItemDataSource : PageKeyedDataSource<Int, UserItem.Item>() {
    val ApiService by lazy {
        RetrofitClient.create()
    }
    companion object{
        public val pageSize: Int = 50
        var pageNo: Int = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UserItem.Item>) {
        pageNo = 1
        ApiService.getUsersList(pageNo, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    it?.body()?.items?.let {
                        if (it.size ==pageSize) {
                            callback.onResult(it, null, pageNo + 1)
                        }

                    }

                }, this::errorResponse)


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserItem.Item>) {
        pageNo = params.key
        ApiService.getUsersList(pageNo, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    it?.body()?.items?.let {
                        if (it.size == pageSize) {
                            Log.v("s:","${it.get(0).websiteUrl}")
                            callback.onResult(it, pageSize+1)
                        }
                    }
                }, this::errorResponse)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserItem.Item>) {

    }


    fun errorResponse(throwable: Throwable) {

    }

}