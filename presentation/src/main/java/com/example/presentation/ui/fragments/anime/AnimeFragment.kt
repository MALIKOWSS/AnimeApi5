package com.example.presentation.ui.fragments.anime

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAnimeBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() = with(binding.recyclerView) {
        adapter = animeAdapter
    }

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() {
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.countriesState.collect{
                    when(it){
                        is UIState.Error -> {
                            Log.e("tag", it.error)
                        }
                        is UIState.Loading -> {
                            binding.progressBar.isVisible = true
                        }
                        is UIState.Success -> {
                            binding.progressBar.isVisible = false
                            animeAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}
