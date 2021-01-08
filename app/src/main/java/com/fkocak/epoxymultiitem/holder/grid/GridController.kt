package com.fkocak.epoxymultiitem.holder.grid

import com.airbnb.epoxy.AsyncEpoxyController
import com.fkocak.epoxymultiitem.RootController
import com.fkocak.epoxymultiitem.data.Message

class GridController(private val listener: RootController.CustomListener) : AsyncEpoxyController()  {

    var messagesss: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        messagesss.forEach {
            normalItem {
                id(it.id)
                message(it)
                listener {
                    listener.onSelected(it)
                }
            }
        }
    }
}