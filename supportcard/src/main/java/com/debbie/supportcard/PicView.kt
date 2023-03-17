package com.debbie.supportcard

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout


class PicView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet
) : RelativeLayout(context, attrs) {

    private val cslItem: List<ViewItem>

    init {
        inflate(context, R.layout.layout_viewpager, this)
        cslItem = listOf(
            ViewItem(R.drawable.img_1, "Bello Yellow Good"),
            ViewItem(R.drawable.img_2, "Mission Impossible"),
            ViewItem(R.drawable.img_3, "Mamba Dance"),
            ViewItem(R.drawable.img_4, "Are You Ready?"),
            ViewItem(R.drawable.img_5, "Pirate Party"),
            ViewItem(R.drawable.img_6, "Romantic Minions Song"),
            ViewItem(R.drawable.img_7, "Juggle Bananas")
        )

        val viewPager = findViewById<View>(R.id.vp_carousel) as ViewPager
        val adapter = ViewAdapterImpl(context)
        adapter.addCardItem(cslItem)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
    }
}