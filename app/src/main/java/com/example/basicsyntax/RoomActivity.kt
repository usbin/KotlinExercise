package com.example.basicsyntax

import android.R.attr
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_room.*


class RoomActivity : AppCompatActivity(){
    var scrollingToBottom : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val data: MutableList<ChattingLog> = loadLog()
        var adapter = RoomAdapter(this, data)
        adapter.listData = data





        rv_chattinglog.adapter = adapter
        rv_chattinglog.layoutManager = LinearLayoutManager(this)
        rv_chattinglog.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            if (bottom < oldBottom) {
                rv_chattinglog.postDelayed(Runnable() {
                    rv_chattinglog.smoothScrollToPosition(data.size-1)
                }, 100)
        }
        }
    }

    fun loadLog() : MutableList<ChattingLog>{
        var data:MutableList<ChattingLog> = mutableListOf()

        for(no in 1..10){
            var name = "name ${no}"
            var text = "Hello ${no}"
            var timestamp = no*10
            data.add(ChattingLog(name, text, timestamp))
        }
        return data
    }

}
