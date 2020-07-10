package com.latty.memoir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_item.view.*

class MemoryStackAdapter(
    private val context: Context,
    private val memoryList: List<MemoryModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MemoryViewHolder(MemoryView: View) : RecyclerView.ViewHolder(MemoryView) {
        val imageView: ImageView = MemoryView.imageView
        val headerTV: TextView = MemoryView.textView1
        val captionTV: TextView = MemoryView.textView2
        val cardView: CardView = MemoryView.cardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MemoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return memoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MemoryViewHolder).headerTV.text = memoryList[position].header
        holder.captionTV.text = memoryList[position].caption
        Glide.with(context).load(memoryList[position].picture).into(holder.imageView)
        //onCLick Listener
//        holder.scratchCardLayout.setOnClickListener {
//            Log.e("scratchCard", "CLICKED")
//            MainActivity().stopScrolling()
//        }
    }
}