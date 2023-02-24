package com.example.animeapi.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glideWith(url: String) {
    Glide.with(this.context).load(url).into(this)
}