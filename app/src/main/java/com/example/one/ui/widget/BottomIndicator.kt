package com.example.one.ui.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2


class BottomIndicator : View {

    private var iconPading: Int = 0 //图标的边距
    private var iconSize: Int = 0 //图标尺寸
    private var textSize: Int = 0 //文字尺寸
    private var viewWidth: Int = 0 //控件的整体宽度
    private var viewHeight: Int = 0 //控件的整体高度
    private var iconMargin: Float = 0.toFloat() // 图标之间的边距
    private var curPosition = 0 //当前位置
    private var offsetX = 0f //偏移量
    private val prePosition = 0 //上次位置
    private var mPaint: Paint? = null //画笔
    private var mDrawableArray: Array<Int>? = null //图标集合
    private var mColorArray: Array<Int>? = null // 颜色集合
    private var mTextArray: Array<String>? = null //文字集合
    private var colorAlpha: Int = 0 //颜色透明度
    private val curX = iconMargin //当前x坐标
    private var textWidth: Float = 0.toFloat()
    private var rightRoundRect: Float = 0.toFloat()
    private var rXY: Int = 0
    private var mViewPagerIndex: Int = 0

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        iconPading = dp2px(6f)
        iconSize = dp2px(24f)
        textSize = dp2px(14f)
        colorAlpha = 50


        mPaint = Paint()
        this.mPaint!!.isAntiAlias = true
        this.mPaint!!.isDither = true
        this.mPaint!!.isFilterBitmap = true
        this.mPaint!!.isFakeBoldText = true
        this.mPaint!!.textSize = textSize.toFloat()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = iconSize + iconPading * 4
        setMeasuredDimension(viewWidth, viewHeight)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        textWidth = mPaint!!.measureText(mTextArray!![0])
        rightRoundRect =
            (viewHeight - 2 * iconPading).toFloat() + (3 * iconPading).toFloat() + iconSize.toFloat() + textWidth
        rXY = (viewHeight - 2 * iconPading) / 2
        iconMargin = (viewWidth.toFloat() - rightRoundRect - (2 * iconSize).toFloat()) / 4

        var position = 0
        var endX = 0f//画一次最后的X坐标
        while (position < mDrawableArray!!.size) {

            if (position == curPosition) {
                val paintColor = getResources().getColor(mColorArray!![position])
                mPaint!!.color = paintColor
                mPaint!!.alpha = colorAlpha

                canvas.drawRoundRect(
                    endX + iconMargin + offsetX,
                    iconPading.toFloat(),
                    endX + iconMargin + offsetX + rightRoundRect,
                    (viewHeight - iconPading).toFloat(),
                    rXY.toFloat(),
                    rXY.toFloat(),
                    mPaint!!
                )

//                canvas.drawRoundRect(
//                    endX + iconMargin + offsetX+rightRoundRect/2-dp2px(10f),
//                    iconPading.toFloat(),
//                    endX + iconMargin + offsetX + rightRoundRect/2+dp2px(10f),
//                    iconPading.toFloat()+dp2px(20f),
//                    dp2px(10f).toFloat(),
//                    dp2px(10f).toFloat(),
//                    mPaint!!
//                )
                mPaint!!.alpha = 255
                val leftBitmap = endX + iconMargin + rXY.toFloat() + iconPading.toFloat()
                canvas.drawBitmap(
                    createBitmap(true, position),
                    leftBitmap,
                    (iconPading * 2).toFloat(),
                    mPaint
                )

                //计算baseline
                val fontMetrics = mPaint!!.fontMetrics
                val distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
                val baseline = viewHeight / 2 + distance
                val textX = leftBitmap + iconPading.toFloat() + iconSize.toFloat()
                canvas.drawText(mTextArray!![position], textX, baseline, mPaint!!)
                endX += iconMargin + rightRoundRect
            } else {
                mPaint!!.alpha = 255
                val leftBitmap = endX + iconMargin
                canvas.drawBitmap(
                    createBitmap(false, position),
                    leftBitmap,
                    (iconPading * 2).toFloat(),
                    mPaint
                )
                endX += iconMargin + iconSize.toFloat()
            }
            position++
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val x = event.x
        val y = event.y
        if (event.action == MotionEvent.ACTION_DOWN) {
            when (curPosition) {
                0 -> if (x >= rightRoundRect + iconMargin * 2 - iconPading * 2
                    && x <= rightRoundRect + iconMargin * 2 + iconSize.toFloat() + (iconPading * 2).toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {

                    itemClickListener!!.onClick(1)
                } else if (x >= rightRoundRect + iconMargin * 3 + iconSize.toFloat() - iconPading * 2
                    && x <= rightRoundRect + iconMargin * 3 + (iconSize * 2).toFloat() + (iconPading * 2).toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {
                    itemClickListener!!.onClick(2)
                }
                1 -> if (x >= iconMargin - iconPading * 2
                    && x <= iconMargin + iconSize.toFloat() + (iconPading * 2).toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {

                    itemClickListener!!.onClick(0)
                } else if (x >= rightRoundRect + iconMargin * 3 + iconSize.toFloat() - iconPading
                    && x <= rightRoundRect + iconMargin * 3 + (iconSize * 2).toFloat() + iconPading.toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {
                    itemClickListener!!.onClick(2)
                }
                2 -> if (x >= iconMargin - iconPading * 2
                    && x <= iconMargin + iconSize.toFloat() + (iconPading * 2).toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {

                    itemClickListener!!.onClick(0)
                } else if (x >= iconMargin * 2 + iconSize - iconPading * 2
                    && x <= iconMargin * 2 + (iconSize * 2).toFloat() + (iconPading * 2).toFloat()
                    && y >= 0
                    && y < viewHeight
                ) {
                    itemClickListener!!.onClick(1)
                }
            }
        }
        return true
    }

    private var itemClickListener: OnItemClickListener? = null

    fun getItemClickListener(): OnItemClickListener? {
        return itemClickListener
    }

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    private fun createBitmap(isSelected: Boolean, position: Int): Bitmap {
        val drawable =
            getResources().getDrawable(mDrawableArray!![position], getContext().getTheme()).mutate()
        val bitmap = Bitmap.createBitmap(iconSize, iconSize, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        if (isSelected) {
            drawable.setTint(getResources().getColor(mColorArray!![position]))
        }
        drawable.draw(canvas)
        return bitmap
    }

    /**
     * 将px值转换为dp值
     */
    fun px2dp(pxValue: Float): Int {
        val scale = getResources().getDisplayMetrics().density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 将dp值转换为px值
     */
    fun dp2px(dpValue: Float): Int {
        val scale = getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun getmDrawableArray(): Array<Int>? {
        return mDrawableArray
    }

    fun setmDrawableArray(mDrawableArray: Array<Int>) {
        this.mDrawableArray = mDrawableArray
    }

    fun getmColorArray(): Array<Int>? {
        return mColorArray
    }

    fun setmColorArray(mColorArray: Array<Int>) {
        this.mColorArray = mColorArray
    }

    fun getmTextArray(): Array<String>? {
        return mTextArray
    }

    fun setmTextArray(mTextArray: Array<String>) {
        this.mTextArray = mTextArray
    }

    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//        Log.e(
//            "LLL",
//            "偏移量：$positionOffset======position:$position==========positionOffsetPixels$positionOffsetPixels"
//        )
        val allOffset = iconSize + iconMargin
        if (mViewPagerIndex == position) {

//            Log.e("LLL", "正在向左滑动")

            if (positionOffset >= 0.8 && positionOffset <= 1) {
                curPosition = position + 1
                offsetX = -(allOffset - positionOffsetPixels * allOffset / viewWidth)

            } else {
                curPosition = position
                offsetX = positionOffsetPixels * allOffset / viewWidth

            }
        } else {

//            Log.e("LLL", "正在向右滑动")
            if (positionOffset >= 0 && positionOffset <= 0.2) {
                curPosition = position
                offsetX = positionOffsetPixels * allOffset / viewWidth
            } else {
                curPosition = position + 1
                offsetX = -(allOffset - positionOffsetPixels * allOffset / viewWidth)
            }

        }
        invalidate()

    }

    fun onPageSelected(position: Int) {}

    fun onPageScrollStateChanged(state: Int, viewPager: ViewPager2) {
        if (state == 1) {//state有三种状态下文会将，当手指刚触碰屏幕时state的值为1，我们就在这个时候给mViewPagerIndex 赋值。
            mViewPagerIndex = viewPager.currentItem
        }

    }
}