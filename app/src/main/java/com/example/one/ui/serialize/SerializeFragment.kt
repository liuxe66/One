package com.example.one.ui.serialize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.one.R
import com.example.one.databinding.FragmentSerializeBindingImpl
import com.hi.dhl.jdatabinding.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_serialize.*


@AndroidEntryPoint
class SerializeFragment : DataBindingFragment() {
    private lateinit var mBinding :FragmentSerializeBindingImpl
    private val mViewModel :SerizlizeViewModel by activityViewModels()
    val mSerializeAdapter:SerializeAdapter by lazy { SerializeAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = binding(inflater,R.layout.fragment_serialize,null)
        return mBinding.apply {
            serializeAdapter = mSerializeAdapter
            serializeViewModel = mViewModel.apply {
                getSerialize().observe(viewLifecycleOwner, Observer {  })
                lifecycleOwner = this@SerializeFragment
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.text = "连载"
        toolbar.setTextColor(resources.getColor(R.color.color_item_serialize,null))
    }
}