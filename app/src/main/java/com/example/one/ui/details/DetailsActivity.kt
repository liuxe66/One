package com.example.one.ui.details

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.one.R
import com.example.one.databinding.ActivityDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.gyf.immersionbar.ImmersionBar
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*


@AndroidEntryPoint
class DetailsActivity : DataBindingAppCompatActivity() {

    //mbinding 通过binding()方法
    private val mBinding: ActivityDetailsBinding by binding(R.layout.activity_details)

    private val mViewModel: DetailsViewModel by viewModels()
    private lateinit var item: String
    private lateinit var id: String
    private lateinit var title: String
    //评论组件功能实现需要的控件
    private var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>? = null
    //评论adapter
    private val mCommentAdapter by lazy { CommentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //状态栏颜色改变
        ImmersionBar.with(this)
            .statusBarColor(R.color.color_white)
            .autoDarkModeEnable(true, 0.2f)
            .fitsSystemWindows(true)
            .keyboardEnable(true)
            .init()

        //从上一个页面传过来
        item = intent.getStringExtra("item")
        id = intent.getStringExtra("id")
        title = intent.getStringExtra("title")

        mBinding.apply {
            //初始化bottomSheetBehavior
            bottomSheetBehavior = BottomSheetBehavior.from(viewComment)
//
//            viewComment.doOnLayout {
//                (bottomSheetBehavior as BottomSheetBehavior<FrameLayout>).addBottomSheetCallback(object :
//                    BottomSheetBehavior.BottomSheetCallback() {
//                    override fun onStateChanged(bottomSheet: View, newState: Int) {
//                        backCallback.isEnabled = newState == BottomSheetBehavior.STATE_EXPANDED
//                    }
//
//                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                        viewComment.translationX =
//                            lerp(maxTranslationX, 0f, 0f, 0.15f, slideOffset)
//                        sheetBackground.interpolation = lerp(1f, 0f, 0f, 0.15f, slideOffset)
//                        sheetBackground.fillColor = ColorStateList.valueOf(
//                            lerpArgb(
//                                sheetStartColor,
//                                sheetEndColor,
//                                0f,
//                                0.3f,
//                                slideOffset
//                            )
//                        )
//                        playlistIcon.alpha = lerp(1f, 0f, 0f, 0.15f, slideOffset)
//                        sheetExpand.alpha = lerp(1f, 0f, 0f, 0.15f, slideOffset)
//                        sheetExpand.visibility = if (slideOffset < 0.5) View.VISIBLE else View.GONE
//                        playlistTitle.alpha = lerp(0f, 1f, 0.2f, 0.8f, slideOffset)
//                        collapsePlaylist.alpha = lerp(0f, 1f, 0.2f, 0.8f, slideOffset)
//                        playlistTitleDivider.alpha = lerp(0f, 1f, 0.2f, 0.8f, slideOffset)
//                        playlist.alpha = lerp(0f, 1f, 0.2f, 0.8f, slideOffset)
//                    }
//                })
//            }

            //xml 变量赋值
            commentAdapter = mCommentAdapter
            detailsModel = mViewModel.apply {
                getDetails(item, id).observe(this@DetailsActivity, Observer {})
                getComment(item, id).observe(this@DetailsActivity, Observer { })
            }

            lifecycleOwner = this@DetailsActivity
        }


    }

    companion object {
        fun jumpAcrtivity(act: Context, item: String?, id: String?, title: String) {
            val intent = Intent(act, DetailsActivity::class.java)
            intent.putExtra("item", item)
            intent.putExtra("id", id)
            intent.putExtra("title", title)
            act.startActivity(intent)
        }
    }
}