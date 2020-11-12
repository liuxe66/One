package com.example.one.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.one.data.model.CommentModel
import com.example.one.data.model.HtmlContentModel
import com.example.one.data.remote.doSuccess
import com.example.one.data.repository.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow

class DetailsViewModel @ViewModelInject constructor(
    private val detailsRepository: Repository
) : ViewModel() {

    private val _details=MutableLiveData<HtmlContentModel>()
    var details:MutableLiveData<HtmlContentModel> = _details

    private val _commnet = MutableLiveData<CommentModel>()
    var comment:MutableLiveData<CommentModel> = _commnet

    fun getDetails(item:String,id:String) = liveData<HtmlContentModel> {
        detailsRepository.getHtmlContent(item, id)
            .collectLatest {result ->
                result.doSuccess { value ->
                    _details.postValue(value)
                    emit(value)
                }
            }
    }

    fun getComment(item:String,id:String) = liveData<CommentModel> {
        detailsRepository.getComment(item, id)
            .collectLatest { result ->
                result.doSuccess { value ->
                    _commnet.postValue(value)
                    emit(value)
                }
            }
    }

}