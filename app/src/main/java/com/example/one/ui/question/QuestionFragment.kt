package com.example.one.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.one.R
import com.example.one.databinding.FragmentHomeBinding
import com.example.one.databinding.FragmentQuestionBinding
import com.example.one.ui.home.HomeViewModel
import com.gyf.immersionbar.ImmersionBar
import com.hi.dhl.jdatabinding.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_question.*


@AndroidEntryPoint
class QuestionFragment : DataBindingFragment() {

    private lateinit var mBinding: FragmentQuestionBinding
    private val mViewModel: QuestionViewModel by activityViewModels()
    val mQuestionAdapter: QuestionAdapter by lazy { QuestionAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = binding(inflater, R.layout.fragment_question, container)

        return mBinding.apply {
            questionAdapter = QuestionAdapter()
            questionModel = mViewModel.apply {
                getQuestion().observe(viewLifecycleOwner, Observer { })
            }
            lifecycleOwner = this@QuestionFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.text = "问答"
        toolbar.setTextColor(resources.getColor(R.color.color_item_question, null))

    }
}