package com.example.animeapi.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.ui.adapters.MangaAdapter
import com.example.animeapi.ui.fragments.home.HomeFragmentDirections
import com.example.youtube.R
import com.example.youtube.databinding.FragmentMangaBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClickFirstListener)

    override fun initialize() {
        binding.recyclerView.adapter = mangaAdapter
    }

    override fun setupSubscribes() {
        subscribeToMangaById()
    }

    private fun subscribeToMangaById() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    fun onClickFirstListener(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}
