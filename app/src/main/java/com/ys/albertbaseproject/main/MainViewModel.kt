package com.ys.albertbaseproject.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ys.albertbaseproject.BaseViewModel
import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import com.ys.albertbaseproject.data.Result
import com.ys.albertbaseproject.data.source.DefaultPostRepository
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val sharedPreferenceStorage: SharedPreferenceStorage, val repository: DefaultPostRepository) : BaseViewModel() {
    val _posts = MutableLiveData<List<Post>>()
    val _comments = MutableLiveData<List<Comment>>()

    fun getTestPrint() = println("call test print")

    fun testSavePreference() {
        sharedPreferenceStorage.put("key", "test")
        println("success test save")
    }

    fun testGetPreference() {
        println(sharedPreferenceStorage.getString("key"))
    }

    suspend fun getPosts() {
        loading.postValue(true)

        viewModelScope.launch {
            repository.getPosts().let {
                when (it) {
                    is Result.Success -> {
                        _posts.value = it.data
                        it.data.forEach { post ->
                            Timber.i("Post Title: ${post.title}")
                        }
                    }
                    is Result.Error -> Timber.e(it.exception)
                }
            }

            loading.postValue(false)
        }
    }

    suspend fun getComments() {
        loading.postValue(true)

        viewModelScope.launch {
            repository.getComments().let {
                when (it) {
                    is Result.Success -> {
                        _comments.value = it.data
                        it.data.forEach { comment ->
                            Timber.i("Comment Body: ${comment.body}")
                        }
                    }
                    is Result.Error -> Timber.e(it.exception)
                }
            }

            loading.postValue(false)
        }
    }

}