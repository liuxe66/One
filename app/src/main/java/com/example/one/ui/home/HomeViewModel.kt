package com.example.one.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.one.data.model.HomeModel
import com.example.one.data.remote.doFailure
import com.example.one.data.remote.doSuccess
import com.example.one.data.repository.Repository
import com.orhanobut.logger.Logger
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart

class HomeViewModel @ViewModelInject constructor(
    private val homeRepository: Repository
) : ViewModel() {

    //私有的 MutableLiveData 可变的，对内访问
    private val _home = MutableLiveData<HomeModel>()

    // 对外暴露不可变的 LiveData，只能查询
    val home: MutableLiveData<HomeModel> = _home

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getHomeData() = liveData<HomeModel> {
        homeRepository.getHomeData()
            .onStart {

            }
            .onEmpty {

            }
            .collectLatest { result ->
                Logger.e("home collectLatest")
                result.doSuccess { value ->
                    _home.postValue(value)
                    emit(value)
                }
                result.doFailure {

                }
            }
    }
}