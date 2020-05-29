package com.example.basicsyntax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_chattingrooms_item.view.*

class CustomAdapter : RecyclerView.Adapter<Holder>(){
    var listData = mutableListOf<ChattingRoom>()

    override fun getItemCount(): Int {
        return listData.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_chattingrooms_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val room = listData.get(position)
        holder.setChattingRoom(room)
    }
}
class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setChattingRoom(room : ChattingRoom){
        itemView.buttonChattingRoom.text = "${room.name}"
        itemView.timestamp.text = "${room.timestamp} minute ago"
    }
}