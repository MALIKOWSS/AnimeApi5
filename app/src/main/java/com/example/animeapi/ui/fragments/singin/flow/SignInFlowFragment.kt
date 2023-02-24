package com.example.animeapi.ui.fragments.singin.flow

import com.example.animeapi.base.BaseFlowFragment
import com.example.youtube.R

class SignInFlowFragment :
    BaseFlowFragment(R.layout.fragment_sing_in_flow) {
    override val navigationId: Int
        get() = R.id.sing_in_host_fragment
}