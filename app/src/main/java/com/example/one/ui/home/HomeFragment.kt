package com.example.one.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.one.R
import com.example.one.databinding.FragmentHomeBinding
import com.gyf.immersionbar.ImmersionBar
import com.hi.dhl.jdatabinding.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment: DataBindingFragment() {

    private lateinit var mBinding : FragmentHomeBinding
    private val mViewModel:HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = binding(inflater,R.layout.fragment_home,container)

        return mBinding.apply {
            item = "essay"
            title = "文章"
            homeModel = mViewModel.apply {
                getHomeData().observe(viewLifecycleOwner, Observer {  })
            }
            lifecycleOwner = this@HomeFragment
        }.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.text = "首页"
        toolbar.setTextColor(resources.getColor(R.color.color_item_home,null))
    }
}