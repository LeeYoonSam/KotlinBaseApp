package com.ys.albertbaseproject.data.source

import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post

interface PostDataSource {
    suspend fun getPosts(): List<Post>?
    suspend fun getComments(): List<Comment>?
}