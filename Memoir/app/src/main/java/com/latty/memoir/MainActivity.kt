package com.latty.memoir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(ContextCompat.getDrawable(this, R.drawable.reveal_picture_1))
            .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 5)))
            .into(backgroundImageView)
    }
}
