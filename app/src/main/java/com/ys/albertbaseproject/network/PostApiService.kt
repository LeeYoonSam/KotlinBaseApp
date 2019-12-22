package com.ys.albertbaseproject.network

import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import retrofit2.http.GET

interface PostApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/comments")
    suspend fun getComments(): List<Comment>
}