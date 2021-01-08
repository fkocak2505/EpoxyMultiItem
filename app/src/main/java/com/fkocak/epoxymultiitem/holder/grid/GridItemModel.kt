package com.fkocak.epoxymultiitem.holder.grid

import android.view.View
import com.airbnb.epoxy.*
import com.fkocak.epoxymultiitem.R
import com.fkocak.epoxymultiitem.RootController
import com.fkocak.epoxymultiitem.data.Data
import com.fkocak.epoxymultiitem.data.Message

@EpoxyModelClass(layout = R.layout.ep_grid_item)
abstract class GridItemModel : EpoxyModelWithHolder<GridItemModel.GridHolder>(),
    RootController.CustomListener {

    @EpoxyAttribute
    lateinit var listener: (Message) -> Unit


    override fun bind(holder: GridHolder) {
        super.bind(holder)

        val controller = GridController(this)
        holder.epoxyRecycler.setController(controller)
        holder.epoxyRecycler.addItemDecoration(EpoxyItemSpacingDecorator(10))
        controller.messagesss = Data.gridItem

    }

    class GridHolder : EpoxyHolder() {

        lateinit var epoxyRecycler: EpoxyRecyclerView

        override fun bindView(itemView: View) {
            epoxyRecycler = itemView.findViewById(R.id.gridER)
        }
    }

    override fun onSelected(suggestion: Message) {
        listener.invoke(suggestion)
    }


}