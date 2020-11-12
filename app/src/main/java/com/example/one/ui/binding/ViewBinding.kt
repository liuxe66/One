package com.example.one.ui.binding

import android.app.Activity
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.one.R
import com.example.one.data.model.CommentModel
import com.example.one.data.model.QuestionModel
import com.example.one.data.model.SerializeModel
import com.example.one.ui.details.CommentAdapter
import com.example.one.ui.details.DetailsActivity
import com.example.one.ui.question.QuestionAdapter
import com.example.one.ui.serialize.SerializeAdapter


@BindingAdapter("bindingAvator")
fun bindingAvator(imageView: ImageView, url: String?) {

    imageView.load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_loading)
    }
}

@BindingAdapter("bindAdapter", "bindData")
fun bindingAdapter(
    recyclerView: RecyclerView,
    questionAdapter: QuestionAdapter?,
    data: ArrayList<QuestionModel.QuestionItemModel>?
) {
    data?.let {
        recyclerView.adapter = questionAdapter
        questionAdapter?.submitList(data)
        questionAdapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("bindSerializeAdapter", "bindSerializeData")
fun bindingAdapter(
    recyclerView: RecyclerView,
    serializeAdapter: SerializeAdapter?,
    data: ArrayList<SerializeModel.SerializeItemModel>?
) {
    data?.let {
        recyclerView.adapter = serializeAdapter
        serializeAdapter?.submitList(data)
        serializeAdapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("bindCommentAdapter", "bindCommentData")
fun bindingAdapter(
    recyclerView: RecyclerView,
    commentAdapter: CommentAdapter?,
    data: ArrayList<CommentModel.CommentItemModel>?
) {
    data?.let {
        recyclerView.adapter = commentAdapter
        commentAdapter?.submitList(data)
        commentAdapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("bindDetailsItem","bindDetailsId","bindDetailsTitle")
fun bindDetailsClick(
    view: View,
    item: String?,
    id: String?,
    title:String
) {
    view.setOnClickListener {
        DetailsActivity.jumpAcrtivity(
            view.context,
            item,
            id,
            title
        )
    }
}

@BindingAdapter("bindDetWeb")
fun bindDetWeb(
    webView: WebView,
    content:String?
){
    webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null)
}

@BindingAdapter("bindFinish")
fun bindFinish(view: View, finish: Boolean) {
    val ctx = view.context
    if (ctx is Activity && finish) {
        view.setOnClickListener { ctx.finish() }
    }
}