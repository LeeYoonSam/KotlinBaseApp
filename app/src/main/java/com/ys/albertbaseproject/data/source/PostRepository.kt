package com.ys.albertbaseproject.data.source

import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import com.ys.albertbaseproject.data.Result

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun getComments(): Result<List<Comment>>
}