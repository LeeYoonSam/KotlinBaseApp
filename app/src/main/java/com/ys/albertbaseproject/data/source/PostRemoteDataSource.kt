package com.ys.albertbaseproject.data.source

import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import com.ys.albertbaseproject.network.PostApiService
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(private val postApiService: PostApiService) : PostDataSource {
    override suspend fun getPosts(): List<Post>? {
        return postApiService.getPosts()
    }

    override suspend fun getComments(): List<Comment>? {
        return postApiService.getComments()
    }
}