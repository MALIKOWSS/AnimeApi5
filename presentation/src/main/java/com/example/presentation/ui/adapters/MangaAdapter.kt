package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.DataItem
import com.example.presentation.databinding.ItemMangaBinding

class MangaAdapter(): ListAdapter<DataItem, MangaAdapter.MangeViewHolder>(
    diffUtil
) {

    inner class MangeViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DataItem) {
            Glide.with(binding.imageIcon.context).load(item.attributes.posterImage.original).into(binding.imageIcon)
            binding.namePerson.text = item.attributes.canonicalTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangeViewHolder {
        return MangeViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MangeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.attributes.canonicalTitle == newItem.attributes.canonicalTitle
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}