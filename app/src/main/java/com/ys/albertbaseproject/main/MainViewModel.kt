package com.ys.albertbaseproject.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ys.albertbaseproject.BaseViewModel
import com.ys.albertbaseproject.data.Comment
import com.ys.albertbaseproject.data.Post
import com.ys.albertbaseproject.data.Result
import com.ys.albertbaseproject.data.source.DefaultPostRepository
import com.ys.albertbaseproject.db.AppDatabase
import com.ys.albertbaseproject.db.SampleFtsEntity
import com.ys.albertbaseproject.storage.SharedPreferenceStorage
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val sharedPreferenceStorage: SharedPreferenceStorage, private val repository: DefaultPostRepository, private val appDatabase: AppDatabase) : BaseViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    private val _comments = MutableLiveData<List<Comment>>()

    init {
        testInsertRoomDb()
    }

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

    private fun testInsertRoomDb() {
        val sampleDatas = listOf(
            SampleFtsEntity("1", "title 1", "description 1"),
            SampleFtsEntity("2", "title 2", "description 2"),
            SampleFtsEntity("3", "title 3", "description 3"),
            SampleFtsEntity("4", "title 4", "description 4"),
            SampleFtsEntity("5", "title 5", "description 5"),
            SampleFtsEntity("6", "title 6", "description 6"),
            SampleFtsEntity("7", "title 7", "description 7"),
            SampleFtsEntity("8", "title 8", "description 8"),
            SampleFtsEntity("9", "title 9", "description 9"),
            SampleFtsEntity("10", "title 10", "description 10")
        )

        viewModelScope.launch {
            appDatabase.sampleFtsDao().insertAll(sampleDatas)
        }
    }

    fun getAllData() {
        viewModelScope.launch {
            val samples = appDatabase.sampleFtsDao().getAllSamples()

            samples.forEach {
                Timber.d("Room DB - title: ${it.title}, description: ${it.description}")
            }
        }
    }

    fun searchData() {
        viewModelScope.launch {
            appDatabase.sampleFtsDao().searchAllSamples("*1*").forEach {
                Timber.d("Room DB - search: $it")
            }
        }
    }
}