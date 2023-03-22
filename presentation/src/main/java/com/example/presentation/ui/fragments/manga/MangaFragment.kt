package com.example.presentation.ui.fragments.manga

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentMangaBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.recyclerView.adapter = mangaAdapter
    }

    override fun setupSubscribes() {
        subscribeToMangaById()
    }

    private fun subscribeToMangaById() {
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
                            mangaAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}