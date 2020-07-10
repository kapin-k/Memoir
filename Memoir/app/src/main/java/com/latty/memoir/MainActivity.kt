package com.latty.memoir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yuyakaido.android.cardstackview.*
import dev.skymansandy.scratchcardlayout.listener.ScratchListener
import dev.skymansandy.scratchcardlayout.ui.ScratchCardLayout
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), CardStackListener {

    private lateinit var layoutManager: CardStackLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Background Image
        Glide.with(this).load(ContextCompat.getDrawable(this, R.drawable.reveal_picture_1))
            .apply(RequestOptions.bitmapTransform(BlurTransformation(10, 3)))
            .into(backgroundImageView)

        // Scratch Card Variables and Listener
        scratchCard.setScratchWidthDip(200f)
        scratchCard.setScratchEnabled(true)
        scratchCard.setScratchListener(object : ScratchListener {
            override fun onScratchComplete() {
                Handler().postDelayed({
                    cardView.visibility = View.GONE
                    cardStack.visibility = View.VISIBLE
                }, 5000)
            }
            override fun onScratchProgress(
                scratchCardLayout: ScratchCardLayout,
                atLeastScratchedPercent: Int
            ) {
//                if (atLeastScratchedPercent > 30) scratchCard.revealScratch()
            }
            override fun onScratchStarted() {
            }
        })

        val memoryList: ArrayList<MemoryModel> = arrayListOf()

        // Show latest memory card - Fetch based on today's date
        val memoryModel = MemoryModel(Calendar.getInstance().time, "", R.drawable.dark_background, "")
        Glide.with(this).load(R.drawable.dark_background).into(imageView)
        headerTV.text = "1 JAN 2019"
        captionTV.text = "Hey how hello hey hey hey hey hey hey"

        // Implement logic to populate memoryList based on calendar
        addToStack(memoryList, memoryModel)

        // Card Stack Adapter
        setCardStackAdapter(memoryList)

    }

    private fun addToStack(memoryList: ArrayList<MemoryModel>, memoryModel: MemoryModel) {
        memoryList.add(memoryModel)
        memoryList.add(
            MemoryModel(
                Calendar.getInstance().time,
                "HEY",
                R.drawable.reveal_picture_1,
                "abfjbfkjsnfansjkfnaansfkln"
            )
        )
        memoryList.add(
            MemoryModel(
                Calendar.getInstance().time,
                "HI",
                R.drawable.reveal_picture_2,
                "abfjbfkjsnfansjkfnasdasdasdasdadadaaansfkln"
            )
        )
        memoryList.add(
            MemoryModel(
                Calendar.getInstance().time,
                "HELLO",
                R.drawable.reveal_picture_3,
                "abfjbfkjsaansfkln"
            )
        )
        memoryList.add(
            MemoryModel(
                Calendar.getInstance().time,
                "HOW ARE YOU",
                R.drawable.reveal_picture_4,
                "abfjbfkjsnfansjkfnaansasdlkasnflanlsfnlanflksanlfnalnflasnffkln"
            )
        )
    }

    private fun setCardStackAdapter(memoryList: ArrayList<MemoryModel>) {
        val adapter = MemoryStackAdapter(this, memoryList)
        layoutManager = CardStackLayoutManager(this, CardStackListener.DEFAULT).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setStackFrom(StackFrom.Top)
            setTranslationInterval(8.0f)
            setScaleInterval(0.95f)
            setMaxDegree(20.0f)
            setSwipeThreshold(0.5f)
            setVisibleCount(3)
        }
        cardStack.layoutManager = layoutManager
        cardStack.adapter = adapter
        cardStack.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardRewound() {
    }
}
