package com.fkocak.epoxymultiitem

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.fkocak.epoxymultiitem.data.Message
import com.fkocak.epoxymultiitem.data.Profile
import com.fkocak.epoxymultiitem.holder.CarouseModelItem_
import com.fkocak.epoxymultiitem.holder.grid.gridItem
import com.fkocak.epoxymultiitem.holder.headerItem
import com.fkocak.epoxymultiitem.holder.normalListItem

class RootController(private val listener: CustomListener): AsyncEpoxyController() {

    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allMessages: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        headerItem {
            id("carousel_item")
            title("Carousel Item")
        }
        val models = recentlyActive.map {
            CarouseModelItem_()
                .id(it.id)
                .profile(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

        headerItem {
            id("all_messages")
            title("All Messages")
        }
        allMessages.forEach {
            normalListItem {
                id(it.id)
                message(it)
                listener {
                    listener.onSelected(it)
                }
            }
        }

        headerItem {
            id("aaaaaafffffff")
            title("All Messages Gridd")
        }
        gridItem {
            id("fffff")
            listener {
                listener.onSelected(it)
            }
        }

    }

    interface CustomListener {
        fun onSelected(suggestion: Message)
    }
}