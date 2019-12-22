package com.ys.albertbaseproject.di

import com.ys.albertbaseproject.data.source.DefaultPostRepository
import com.ys.albertbaseproject.data.source.PostDataSource
import com.ys.albertbaseproject.data.source.PostRemoteDataSource
import com.ys.albertbaseproject.data.source.PostRepository
import com.ys.albertbaseproject.network.PostApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {
    @Provides
    @Singleton
    fun providePostRemoteDataSource(postApiService: PostApiService): PostDataSource {
        return PostRemoteDataSource(postApiService)
    }

    @Provides
    @Singleton
    fun providePostRepository(postRemoteDataSource: PostRemoteDataSource): PostRepository {
        return DefaultPostRepository(postRemoteDataSource)
    }
}