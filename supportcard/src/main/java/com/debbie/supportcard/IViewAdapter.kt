package com.debbie.supportcard

import android.support.v7.widget.CardView


val MAX_ELEVATION_FACTOR = 4

interface IViewAdapter {
    fun getBaseElevation(): Float
    fun getCardViewAt(position: Int): CardView?
    fun getCount(): Int
}