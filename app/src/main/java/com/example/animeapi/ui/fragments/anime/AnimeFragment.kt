package com.example.animeapi.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.ui.adapters.AnimeAdapter
import com.example.animeapi.ui.fragments.home.HomeFragmentDirections
import com.example.youtube.R
import com.example.youtube.databinding.FragmentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    private val animeAdapter = AnimeAdapter(this::onClickFirstListener)
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()

    override fun initialize() = with(binding.recyclerView) {
        adapter = animeAdapter
    }

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onClickFirstListener(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(
                id.toInt()
            )
        )
    }
}
