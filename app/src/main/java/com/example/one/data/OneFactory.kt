package com.example.one.data

import com.example.one.data.remote.OneService
import com.example.one.data.repository.OneRepositoryImpl
import com.example.one.data.repository.Repository

object OneFactory {
    fun makePokemonRepository(api: OneService): Repository  =
        OneRepositoryImpl(api)
}