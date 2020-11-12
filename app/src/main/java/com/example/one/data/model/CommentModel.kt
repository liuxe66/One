package com.example.one.data.model

import androidx.recyclerview.widget.DiffUtil

data class CommentModel(
  val data:ArrayList<CommentItemModel>
){
    data class CommentItemModel(
        val userId:String,
        val userName:String,
        val userImg:String,
        val publishTime:String,
        val contentTxt:String,
        val praiseNum:String
    ){
        companion object {
            val diffCallback = object : DiffUtil.ItemCallback<CommentModel.CommentItemModel>() {
                override fun areItemsTheSame(
                    oldItem: CommentModel.CommentItemModel,
                    newItem: CommentModel.CommentItemModel
                ): Boolean =
                    oldItem.userId == newItem.userId

                override fun areContentsTheSame(
                    oldItem: CommentModel.CommentItemModel,
                    newItem: CommentModel.CommentItemModel
                ): Boolean =
                    oldItem == newItem
            }
        }
    }
}