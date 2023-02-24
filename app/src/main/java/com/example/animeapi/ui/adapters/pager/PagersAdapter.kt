package com.example.animeapi.ui.adapters.pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.animeapi.ui.fragments.anime.AnimeFragment
import com.example.animeapi.ui.fragments.manga.MangaFragment

class PagersAdapter(fragment: Fragment): FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            else -> MangaFragment()
        }
    }
}