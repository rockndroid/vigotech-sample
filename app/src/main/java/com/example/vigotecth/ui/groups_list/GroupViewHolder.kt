package com.example.vigotecth.ui.groups_list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vigotecth.data.model.Group
import com.example.vigotecth.databinding.ListitemGroupBinding

class GroupViewHolder(private val binding: ListitemGroupBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(group: Group) {
        binding.txtName.text = group.name

        Glide.with(itemView.context)
            .load(group.image)
            .into(binding.imgGroup)
    }
}