package com.example.basicsyntax

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rvitem_mylog.view.*
import kotlinx.android.synthetic.main.rvitem_room.view.*

class RoomAdapter(val context: Context, var listData : MutableList<ChattingLog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int {
        return listData.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        var view : View
        if(viewType == 1){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rvitem_room, parent, false)
            return LogHolder(view)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rvitem_mylog, parent, false)
            return MyLogHolder(view)
        }

    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val log = listData.get(position)
        if(viewHolder is LogHolder){
            viewHolder.setChattingRoom(log)
        }
        else if(viewHolder is MyLogHolder){
            viewHolder.setChattingRoom(log)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(position%2 == 0){
            1
        } else {
            2
        }
    }

}
class LogHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setChattingRoom(log : ChattingLog){
        itemView.roomlog_name.text = "${log.name}"
        itemView.roomlog_text.text = "Hello~!"
        itemView.roomlog_timestamp.text = "${log.timestamp +1} min ago"

    }
}
class MyLogHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setChattingRoom(log : ChattingLog){
        itemView.myroomlog_text.text = "${log.text}"
        itemView.myroomlog_timestamp.text = "${log.timestamp +1} min ago"
    }
}