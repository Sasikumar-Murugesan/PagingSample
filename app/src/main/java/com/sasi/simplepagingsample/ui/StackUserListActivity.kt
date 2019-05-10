package com.sasi.simplepagingsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sasi.simplepagingsample.R
import com.sasi.simplepagingsample.databinding.ActivityStackUserListBinding
import com.sasi.simplepagingsample.paging.StackUserListAdapter
import com.sasi.simplepagingsample.viewmodel.StackUserViewModel

class StackUserListActivity : AppCompatActivity() {
    var viewModel: StackUserViewModel? = null
    lateinit var binding: ActivityStackUserListBinding
    var adapter: StackUserListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stack_user_list)
        viewModel = ViewModelProviders.of(this).get(StackUserViewModel::class.java)
        binding.viewModel = viewModel
        adapter = StackUserListAdapter()
        viewModel?.userItemPagedList?.observe(this, Observer {
            adapter?.submitList(it)
        })

        binding.rvStackList.adapter = adapter

    }
}
