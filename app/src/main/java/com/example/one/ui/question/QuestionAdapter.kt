package com.example.one.ui.question

import android.view.View
import com.example.one.R
import com.example.one.data.model.QuestionModel
import com.example.one.databinding.RecycleItemQuestionBinding
import com.hi.dhl.jdatabinding.DataBindingListAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder


class QuestionAdapter :
    DataBindingListAdapter<QuestionModel.QuestionItemModel>(QuestionModel.QuestionItemModel.diffCallback) {
    override fun layout(position: Int): Int = R.layout.recycle_item_question

    override fun viewHolder(
        layout: Int,
        view: View
    ): DataBindingViewHolder<QuestionModel.QuestionItemModel> = QuestionViewHolder(view)
}

class QuestionViewHolder(view: View) : DataBindingViewHolder<QuestionModel.QuestionItemModel>(view) {

    private val mBinding: RecycleItemQuestionBinding by viewHolderBinding(view)

    override fun bindData(data: QuestionModel.QuestionItemModel, position: Int) {
        mBinding.apply {
            item = "question"
            title = "问答"
            questionItemModel = data
            executePendingBindings()
        }
    }

}