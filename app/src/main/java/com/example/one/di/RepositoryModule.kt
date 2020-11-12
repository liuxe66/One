package com.example.one.di

import com.example.one.data.OneFactory
import com.example.one.data.remote.OneService
import com.example.one.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTasksRepository(
        api: OneService
    ): Repository {
        return OneFactory.makePokemonRepository(api)
    }

}