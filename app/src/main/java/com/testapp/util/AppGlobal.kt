package com.example.testapp.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class AppGlobal {
    companion object {
        //Arguments
        var ARG_USER = "ARG_USER"
        fun loadImageUrl(context: Context, imageView: ImageView, url: String) {
            Glide.with(context)
                .load(url)
                .fitCenter()// image url // any placeholder to load at start
                .into(imageView)
        }
    }
}