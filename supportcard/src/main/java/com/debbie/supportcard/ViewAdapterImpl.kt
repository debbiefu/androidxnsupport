package com.debbie.supportcard

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class ViewAdapterImpl(
    private val context: Context
): androidx.viewpager.widget.PagerAdapter(), IViewAdapter {

    private val cardViews: ArrayList<CardView?> = ArrayList()
    private val cslItems: ArrayList<ViewItem> = ArrayList()
    private var baseElevation = 0f

    fun addCardItem(items: List<ViewItem>) {
        cslItems.addAll(items)
        for (i in cslItems.indices) {
            cardViews.add(null)
        }
    }

    override fun getBaseElevation(): Float = baseElevation

    override fun getCardViewAt(position: Int): CardView? = cardViews[position]

    override fun getCount(): Int = cslItems.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = (view == obj)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(container.context).inflate(R.layout.viewpager_item, container, false)

        container.addView(view)
        bindView(cslItems[position], view)

        val cardView = view.findViewById<View>(R.id.carousel_cardView) as CardView
        cardView.setOnClickListener {
            Toast.makeText(
                context, "Selected: " + cslItems[position].name,
                Toast.LENGTH_SHORT
            ).show()
        }

        val ivFavorite: ImageView = view.findViewById<View>(R.id.iv_favorite) as ImageView
        if (position % 2 == 1) {
            ivFavorite.visibility = View.VISIBLE
        } else {
            ivFavorite.visibility = View.GONE
        }

        if (baseElevation == 0f) {
            baseElevation = cardView.cardElevation
        }
        cardView.maxCardElevation = baseElevation * MAX_ELEVATION_FACTOR
        cardViews[position] = cardView
        return view
    }

    private fun bindView(item: ViewItem, view: View) {
        val ivItemImage = view.findViewById<View>(R.id.iv_card_view) as ImageView
        ivItemImage.setImageResource(item.image)
        val tvTitle = view.findViewById<View>(R.id.tv_item_name) as TextView
        tvTitle.text = item.name
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
        cardViews[position] = null
    }
}