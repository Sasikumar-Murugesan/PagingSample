package com.sasi.simplepagingsample.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.sasi.simplepagingsample.databinding.RowViewUserItemBinding
import com.sasi.simplepagingsample.model.UserItem

class StackUserListAdapter : PagedListAdapter<UserItem.Item, StackUserListAdapter.UserVH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return UserVH(RowViewUserItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(getItem(position))
    }

    class UserVH(var binding: RowViewUserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserItem.Item?) {
            binding.textView.setText(item?.link.toString())
        }

    }

    companion object {
        var diffCallback = object : ItemCallback<UserItem.Item>() {
            override fun areItemsTheSame(oldItem: UserItem.Item, newItem: UserItem.Item): Boolean {
                return oldItem.accountId == newItem.accountId
            }

            override fun areContentsTheSame(oldItem: UserItem.Item, newItem: UserItem.Item): Boolean {
                return oldItem == newItem
            }

        }
    }

}

