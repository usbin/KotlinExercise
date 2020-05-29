package com.example.basicsyntax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rvitem_chattingroom.view.*
import kotlinx.android.synthetic.main.rvitem_room.view.*

class RoomAdapter : RecyclerView.Adapter<LogHolder>(){
    var listData = mutableListOf<ChattingLog>()

    override fun getItemCount(): Int {
        return listData.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvitem_room, parent, false)
        return LogHolder(view)
    }

    override fun onBindViewHolder(holder: LogHolder, position: Int) {
        val log = listData.get(position)
        holder.setChattingRoom(log)
    }
}
class LogHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setChattingRoom(log : ChattingLog){
        itemView.roomlog_name.text = "${log.name}"
        itemView.roomlog_text.text = "Hello~!"
        itemView.roomlog_timestamp.text = "${log.timestamp +1} minute ago"
        
    }
}