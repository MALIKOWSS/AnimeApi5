package com.example.animeapi.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.extension.glideWith
import com.example.animeapi.extension.showText
import com.example.youtube.R
import com.example.youtube.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.fetchAnimeById(args.id).subscribe(
            onError ={
                     showText(it)
            },
            onSuccess = {
                it.data.let { anime ->
                    binding.ivImage.glideWith(anime.attributes.posterImage.original)
                    title.text = anime.attributes.titles.enJp
                }
            }
        )
    }
}