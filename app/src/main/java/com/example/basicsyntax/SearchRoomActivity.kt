package com.example.basicsyntax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search_room.*

class SearchRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search_room)



        val data:MutableList<ChattingRoom> = loadSearchData()
        var adapter = CustomAdapter()
        adapter.listData = data

        rv_searchroom_result.adapter = adapter
        rv_searchroom_result.layoutManager = LinearLayoutManager(this)
    }
    fun loadSearchData() : MutableList<ChattingRoom>{
        var data:MutableList<ChattingRoom> = mutableListOf()
        for (i in 1..10) {
            val searched = ChattingRoom("searched room ${i}", i*10)
            data.add(searched)
        }
        return data
    }
}