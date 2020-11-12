package com.example.one.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.one.R
import com.example.one.ui.home.HomeFragment
import com.example.one.ui.question.QuestionFragment
import com.example.one.ui.serialize.SerializeFragment
import com.example.one.ui.widget.BottomIndicator
import com.example.one.ui.widget.ViewPagerHelper
import com.gyf.immersionbar.ImmersionBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val colorArray: Array<Int> =
        arrayOf(R.color.color_item_home, R.color.color_item_question, R.color.color_item_serialize)
    private val drawableArray: Array<Int> =
        arrayOf(R.drawable.ic_home, R.drawable.ic_question, R.drawable.ic_serialize)
    private val textArray: Array<String> = arrayOf("首页", "问答", "连载")
    val fragmentArray :Array<Fragment> = arrayOf(HomeFragment(),QuestionFragment(),SerializeFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initStatusBar()

        bottomIndicator.setmColorArray(colorArray)
        bottomIndicator.setmDrawableArray(drawableArray)
        bottomIndicator.setmTextArray(textArray)

        viewpager.adapter =
            MainPagerAdapter(this)
        viewpager.offscreenPageLimit = fragmentArray.size
        ViewPagerHelper.bind(bottomIndicator, viewpager)

        bottomIndicator.setItemClickListener(object : BottomIndicator.OnItemClickListener {
            override fun onClick(position: Int) {
                viewpager.currentItem = position
            }
        })
    }

    fun initStatusBar() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.color_white)
            .autoDarkModeEnable(true, 0.2f)
            .fitsSystemWindows(true)
            .keyboardEnable(true)
            .init()

    }

    inner class MainPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return fragmentArray[position]
        }
    }
}