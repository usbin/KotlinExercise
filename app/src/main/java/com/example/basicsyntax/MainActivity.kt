package com.example.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data:MutableList<ChattingRoom> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data

        rvChattingRooms.adapter = adapter
        rvChattingRooms.layoutManager = LinearLayoutManager(this)

    }
    fun loadData() : MutableList<ChattingRoom>{
        var data:MutableList<ChattingRoom> = mutableListOf()

        for(no in 1..20){
            var name = "Chatting Room ${no}"
            var timestamp = no*10
            var chattingRoom = ChattingRoom(name, timestamp)
            data.add(chattingRoom)
        }
        return data
    }
}
