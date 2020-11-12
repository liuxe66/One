package com.example.one.data.model

import androidx.recyclerview.widget.DiffUtil

data class QuestionModel (
    val data:ArrayList<QuestionItemModel>
){
    data class QuestionItemModel(
        val qId:String,
        val qTitle:String,
        val qSubTitle:String,
        val qImgUrl:String
    ){
        companion object {
            val diffCallback = object : DiffUtil.ItemCallback<QuestionItemModel>() {
                override fun areItemsTheSame(
                    oldItem: QuestionItemModel,
                    newItem: QuestionItemModel
                ): Boolean =
                    oldItem.qId == newItem.qId

                override fun areContentsTheSame(
                    oldItem: QuestionItemModel,
                    newItem: QuestionItemModel
                ): Boolean =
                    oldItem == newItem
            }
        }

        override fun toString(): String {
            return "qid:"+qId+",qtitle:"+qTitle+",qsubtitle:"+qSubTitle
        }
    }
}