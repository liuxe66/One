package com.example.one.ui.details

import android.view.View
import com.example.one.R
import com.example.one.data.model.CommentModel
import com.example.one.data.model.QuestionModel
import com.example.one.databinding.RecycleItemCommentBinding
import com.example.one.databinding.RecycleItemQuestionBinding
import com.example.one.ui.question.QuestionViewHolder
import com.hi.dhl.jdatabinding.DataBindingListAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder


class CommentAdapter :
    DataBindingListAdapter<CommentModel.CommentItemModel>(CommentModel.CommentItemModel.diffCallback) {
    override fun layout(position: Int): Int = R.layout.recycle_item_comment

    override fun viewHolder(
        layout: Int,
        view: View
    ): DataBindingViewHolder<CommentModel.CommentItemModel> = CommentViewHolder(view)
}

class CommentViewHolder(view: View) : DataBindingViewHolder<CommentModel.CommentItemModel>(view) {

    private val mBinding: RecycleItemCommentBinding by viewHolderBinding(view)

    override fun bindData(data: CommentModel.CommentItemModel, position: Int) {
        mBinding.apply {
            commentItem = data
            executePendingBindings()
        }
    }

}