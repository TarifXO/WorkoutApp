package com.example.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workout.databinding.ItemHistoryRowBinding



class HistoryAdapter(private val items : ArrayList<String>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(binding : ItemHistoryRowBinding) : RecyclerView.ViewHolder(binding.root){
        val llHistoryItemMain = binding.llHistoryItemMain
        val tvItem = binding.tvItem
        val tvPosition = binding.tvPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date : String = items.get(position)
        holder.tvPosition.text = (position +1).toString()
        holder.tvItem.text = date

        if (position % 2 == 0){
            holder.llHistoryItemMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.colorGray))
        }else{
            holder.llHistoryItemMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        }
    }
}