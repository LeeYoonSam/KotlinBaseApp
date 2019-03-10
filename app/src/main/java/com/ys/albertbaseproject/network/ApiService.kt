package com.ys.albertbaseproject.network

import com.ys.albertbaseproject.network.dto.TestData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/api/test")
    fun getTest(): Single<TestData.TestDataRes>
}