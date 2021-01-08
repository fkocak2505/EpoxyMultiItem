package com.fkocak.epoxymultiitem.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.fkocak.epoxymultiitem.R

@EpoxyModelClass(layout = R.layout.ep_header_item)
abstract class HeaderItemModel: EpoxyModelWithHolder<HeaderItemModel.HeaderHolder>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: HeaderHolder) {
        super.bind(holder)
        holder.title.text = title
    }

    class HeaderHolder : EpoxyHolder() {

        lateinit var title: AppCompatTextView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.header_title)
        }
    }

}