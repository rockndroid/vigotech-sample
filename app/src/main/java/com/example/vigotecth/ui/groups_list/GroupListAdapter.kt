package com.example.vigotecth.ui.groups_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vigotecth.data.model.Group
import com.example.vigotecth.databinding.ListitemGroupBinding

class GroupListAdapter: RecyclerView.Adapter<GroupViewHolder>() {
    private var groups: List<Group> = emptyList()

    fun submitGroups(groups: List<Group>) {
        this.groups = groups
        notifyItemRangeInserted(0, groups.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = ListitemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(groups[position])
    }

    override fun getItemCount(): Int = groups.size

}