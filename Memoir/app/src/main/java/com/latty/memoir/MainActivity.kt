package com.latty.memoir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.skymansandy.scratchcardlayout.listener.ScratchListener
import dev.skymansandy.scratchcardlayout.ui.ScratchCardLayout
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Background Image
        Glide.with(this).load(ContextCompat.getDrawable(this, R.drawable.reveal_picture_1))
            .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 3)))
            .into(backgroundImageView)

        // Scratch Card Variables
        scratchCard.setScratchWidthDip(80f)
//        scratchCard.setScratchEnabled(true)
//        scratchCard.setScratchListener(object : ScratchListener {
//            override fun onScratchComplete() {
//                scratchCard.resetScratch()
//            }
//
//            override fun onScratchProgress(
//                scratchCardLayout: ScratchCardLayout,
//                atLeastScratchedPercent: Int
//            ) {
//                if (atLeastScratchedPercent > 50) scratchCard.revealScratch()
//            }
//
//            override fun onScratchStarted() {
//            }
//        })

        

    }
}
