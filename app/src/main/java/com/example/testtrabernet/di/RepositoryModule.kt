package com.example.testtrabernet.di

import android.content.Context
import com.example.testtrabernet.model.repository.Repository
import com.example.testtrabernet.model.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun repositoryProvider(@ApplicationContext context: Context) : Repository {
        return RepositoryImp(context)
    }
}