package com.sasi.simplepagingsample.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.sasi.simplepagingsample.model.UserItem
import com.sasi.simplepagingsample.paging.UserListItemDataSource
import com.sasi.simplepagingsample.paging.UserListItemDataSourceFactory
import com.sasi.simplepagingsample.retrofit.RetrofitClient
import com.sasi.simplepagingsample.utils.ObservableViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


class StackUserViewModel(application: Application) : ObservableViewModel(application) {
    var userItemPagedList: LiveData<PagedList<UserItem.Item>>? = null
    var liveDataSource: LiveData<PageKeyedDataSource<Int, UserItem.Item>>? = null

    init {
        var userListItemDataSourceFactory = UserListItemDataSourceFactory()
        liveDataSource = userListItemDataSourceFactory.itemLiveDataSource
        var pagingConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserListItemDataSource.pageSize)
            .build()
        userItemPagedList = LivePagedListBuilder(userListItemDataSourceFactory, pagingConfig).build()
    }


}