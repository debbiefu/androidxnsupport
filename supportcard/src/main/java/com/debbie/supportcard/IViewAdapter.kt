package com.debbie.supportcard

import androidx.cardview.widget.CardView


val MAX_ELEVATION_FACTOR = 4

interface IViewAdapter {
    fun getBaseElevation(): Float
    fun getCardViewAt(position: Int): CardView?
    fun getCount(): Int
}