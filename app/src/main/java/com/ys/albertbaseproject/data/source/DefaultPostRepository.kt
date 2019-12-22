package com.ys.albertbaseproject.data.source

import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import com.ys.albertbaseproject.data.Result
import com.ys.albertbaseproject.data.Result.Success
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(private val postRemoteDataSource: PostRemoteDataSource) : PostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val posts = postRemoteDataSource.getPosts()
            posts?.let {
                Success(it)
            } ?: Success(emptyList())

        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun getComments(): Result<List<Comment>> {
        return try {
            val comments = postRemoteDataSource.getComments()
            comments?.let {
                Success(it)
            } ?: Success(emptyList())

        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}