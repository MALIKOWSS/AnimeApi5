package com.example.animeapi.ui.fragments.singin

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapi.base.BaseFragment
import com.example.animeapi.data.locale.preferences.userdata.UserPreferencesData
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.extension.showText
import com.example.youtube.R
import com.example.youtube.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {
        binding.buttonSend.setOnClickListener {
            val email = textEmail.text.toString()
            val password = textPassword.text.toString()
            if (email.isEmpty() || password.isEmpty())
                showText("Введите свои данные")
            val authModel = AuthModel("password", email, password)
            viewModel.fetchSingIn(authModel).subscribe(
                onError = {
                    Log.e("tag", "log: $it")
                },
                onSuccess = { token ->
                    showText("$token")
                    if (token != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = token.accessToken
                            refreshToken = token.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(
                            R.id.action_singInFlowFragment_to_homeFlowFragment
                        )
                    }
                }
            )
        }
    }
}