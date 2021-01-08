package com.fkocak.epoxymultiitem.holder

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.fkocak.epoxymultiitem.R
import com.fkocak.epoxymultiitem.data.Profile

@EpoxyModelClass(layout = R.layout.ep_carousel_item)
abstract class CarouseModelItem: EpoxyModelWithHolder<CarouseModelItem.CarouselHolder>() {

    @EpoxyAttribute
    lateinit var profile: Profile

    override fun bind(holder: CarouselHolder) {
        super.bind(holder)
        with(profile) {
            holder.profileName.text = name
            holder.lastSeen.text = lastSeen
        }
    }

    class CarouselHolder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var profileName: AppCompatTextView
        lateinit var lastSeen: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.recently_added_profile_image)
            profileName = itemView.findViewById(R.id.recently_added_profile_name)
            lastSeen = itemView.findViewById(R.id.recently_added_last_seen)
        }
    }

}