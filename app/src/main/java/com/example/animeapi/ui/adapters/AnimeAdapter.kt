package com.example.animeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapi.data.models.anime.DataItem
import com.example.animeapi.extension.glideWith
import com.example.youtube.databinding.ItemNameBinding

class AnimeAdapter(private val onClickListener: (id: String) -> Unit) :
    PagingDataAdapter<DataItem, AnimeAdapter.AnimeViewHolder>(
        diffUtil
    ) {

    inner class AnimeViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DataItem) {
            binding.imageIcon.glideWith(item.attributes.posterImage.original)
            binding.namePerson.text = item.attributes.titles.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply {
                    onClickListener(id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}