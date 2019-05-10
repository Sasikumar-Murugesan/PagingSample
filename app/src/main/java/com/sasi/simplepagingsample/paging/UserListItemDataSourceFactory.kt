package com.sasi.simplepagingsample.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.sasi.simplepagingsample.model.UserItem


class UserListItemDataSourceFactory : DataSource.Factory<Int, UserItem.Item>() {
    var itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, UserItem.Item>>()
    override fun create(): DataSource<Int, UserItem.Item> {
        var itemDataSource = UserListItemDataSource()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }

}