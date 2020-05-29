package com.example.basicsyntax

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
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

        //챗봇 클릭했을 때의 리스너
        buttonChatBot.setOnClickListener {
            val nextIntent = Intent(this, RoomActivity::class.java)
            startActivity(nextIntent)
        }

        button_chattingroom_menu.setOnClickListener {
            var menuPopup = PopupMenu(this, button_chattingroom_menu)
            menuPopup.menuInflater.inflate(R.menu.menu_chattingroom_top, menuPopup.menu)
            
            menuPopup.setOnMenuItemClickListener {
                val item = it.itemId

                when(item){
                    R.id.menuitem_createroom -> {
                        val nextIntent = Intent(this, CreateRoomAcvitivy::class.java)
                        startActivity(nextIntent)
                    }
                    R.id.menuitem_searchroom -> {
                        val nextIntent = Intent(this, SearchRoomActivity::class.java)
                        startActivity(nextIntent)

                    }
                }
                true


            }
            menuPopup.show()
            
            
        }
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


    fun goBack(){
        onBackPressed()
    }
}
