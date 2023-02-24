package com.example.animeapi.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.extension.glideWith
import com.example.animeapi.extension.showText
import com.example.youtube.R
import com.example.youtube.databinding.FragmentMangaDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    private val args by navArgs<MangaDetailFragmentArgs>()
    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() = with(binding) {
        viewModel.fetchMangaById(args.id).subscribe(
            onError ={
                     showText(it)
            },
            onSuccess = {
                it.data.let { manga ->
                    binding.ivImage.glideWith(manga.attributes.posterImage.original)
                    title.text = manga.attributes.titles.enJp
                }
            }
        )
    }
}