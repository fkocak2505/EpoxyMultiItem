package com.fkocak.epoxymultiitem.holder.grid

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.fkocak.epoxymultiitem.R
import com.fkocak.epoxymultiitem.data.Message
import com.google.android.material.card.MaterialCardView

@EpoxyModelClass(layout = R.layout.ep_sub_grid_item)
abstract class NormalItemModel : EpoxyModelWithHolder<NormalItemModel.NormalItemHolder>() {

    @EpoxyAttribute
    lateinit var message: Message

    @EpoxyAttribute
    lateinit var listener: (Message) -> Unit


    override fun bind(holder: NormalItemHolder) {
        super.bind(holder)
        with(message) {
            holder.title.text = username
        }

        holder.cl.setOnClickListener {
            listener.invoke(message)
        }
    }

    class NormalItemHolder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var title: AppCompatTextView
        lateinit var cl: MaterialCardView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.grid_item_icon)
            title = itemView.findViewById(R.id.grid_item_title)
            cl = itemView.findViewById(R.id.ffawfawf)

        }
    }
}