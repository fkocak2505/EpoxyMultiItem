package com.fkocak.epoxymultiitem.holder

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

@EpoxyModelClass(layout = R.layout.ep_normal_item)
abstract class NormalListItem: EpoxyModelWithHolder<NormalListItem.NormalHolder>() {

    @EpoxyAttribute
    lateinit var message: Message

    @EpoxyAttribute
    lateinit var listener: (Message) -> Unit


    override fun bind(holder: NormalHolder) {
        super.bind(holder)
        with(message) {
            holder.title.text = username
            holder.content.text = content
        }

        holder.aaaa.setOnClickListener {
            listener.invoke(message)
        }
    }

    class NormalHolder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var title: AppCompatTextView
        lateinit var content: AppCompatTextView
        lateinit var aaaa: MaterialCardView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.message_profile_image)
            title = itemView.findViewById(R.id.message_profile_name)
            content = itemView.findViewById(R.id.message_content)
            aaaa = itemView.findViewById(R.id.aaaaaaa)

        }
    }

}