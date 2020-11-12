package com.example.one.data.model

import androidx.recyclerview.widget.DiffUtil

data class SerializeModel(
    val data: ArrayList<SerializeItemModel>
) {

    data class SerializeItemModel(
        val id: String,
        val title: String,
        val subTitle: String,
        val serial_id: String,
        val imgUrl: String,
        val content: String,
        val finished: Boolean
    ) {
        companion object {
            val diffCallback = object : DiffUtil.ItemCallback<SerializeModel.SerializeItemModel>() {
                override fun areItemsTheSame(
                    oldItem: SerializeModel.SerializeItemModel,
                    newItem: SerializeModel.SerializeItemModel
                ): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: SerializeModel.SerializeItemModel,
                    newItem: SerializeModel.SerializeItemModel
                ): Boolean =
                    oldItem == newItem
            }
        }
    }
}