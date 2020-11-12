package com.example.one.ui.question

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.one.data.model.QuestionModel
import com.example.one.data.remote.doSuccess
import com.example.one.data.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class QuestionViewModel @ViewModelInject constructor(
    private val questionRepository: Repository
) : ViewModel() {
    //私有的 MutableLiveData 可变的，对内访问
    private val _question = MutableLiveData<QuestionModel>()

    // 对外暴露不可变的 LiveData，只能查询
    val question: MutableLiveData<QuestionModel> = _question

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getQuestion() = liveData<QuestionModel> {
        questionRepository.getQuestion()
            .collectLatest { result ->
                result.doSuccess { value ->
                    _question.postValue(value)
                    emit(value)
                }
            }
    }
}