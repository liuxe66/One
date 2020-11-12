package com.example.one.ui.serialize

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.one.data.model.SerializeModel
import com.example.one.data.remote.doSuccess
import com.example.one.data.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class SerizlizeViewModel @ViewModelInject constructor(
    private val serializeRepository: Repository
) : ViewModel() {

    private val _serialize = MutableLiveData<SerializeModel>()
    var serialize: MutableLiveData<SerializeModel> = _serialize

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getSerialize() = liveData<SerializeModel> {
        serializeRepository.getSerialize()
            .collectLatest { result ->
                result.doSuccess { value ->
                    _serialize.postValue(value)
                    emit(value)
                }
            }
    }
}