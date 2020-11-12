package com.example.one.ui.widget

import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

object ViewPagerHelper {
    fun bind(indicator: BottomIndicator, viewPager: ViewPager2) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                indicator.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                indicator.onPageScrollStateChanged(state, viewPager)
            }
        })
    }
}