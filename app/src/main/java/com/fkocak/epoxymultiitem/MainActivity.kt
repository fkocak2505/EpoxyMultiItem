package com.fkocak.epoxymultiitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fkocak.epoxymultiitem.data.Data
import com.fkocak.epoxymultiitem.data.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RootController.CustomListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = RootController(this)
        messagesView.setController(controller)
        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive

    }

    override fun onSelected(suggestion: Message) {
        Toast.makeText(applicationContext, suggestion.username, Toast.LENGTH_SHORT).show()
    }

}