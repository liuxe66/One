package com.example.one.ui.serialize

import android.view.View
import com.example.one.R
import com.example.one.data.model.QuestionModel
import com.example.one.data.model.SerializeModel
import com.example.one.databinding.RecycleItemQuestionBinding
import com.example.one.databinding.RecycleItemSerializeBinding
import com.example.one.ui.question.QuestionViewHolder
import com.hi.dhl.jdatabinding.DataBindingListAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder


class SerializeAdapter :
    DataBindingListAdapter<SerializeModel.SerializeItemModel>(SerializeModel.SerializeItemModel.diffCallback) {
    override fun layout(position: Int): Int = R.layout.recycle_item_serialize

    override fun viewHolder(
        layout: Int,
        view: View
    ): DataBindingViewHolder<SerializeModel.SerializeItemModel> = SerializeViewHolder(view)
}

class SerializeViewHolder(view: View) : DataBindingViewHolder<SerializeModel.SerializeItemModel>(view) {

    private val mBinding: RecycleItemSerializeBinding by viewHolderBinding(view)

    override fun bindData(data: SerializeModel.SerializeItemModel, position: Int) {
        mBinding.apply {
            serizlizeItem = data
            executePendingBindings()
        }
    }

}