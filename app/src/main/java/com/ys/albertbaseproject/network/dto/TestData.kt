package com.ys.albertbaseproject.network.dto

import com.google.gson.annotations.SerializedName

class TestData {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("age")
    var age: Int = 0

    class TestDataeReq {
        var email: String? = null
        var pwd: String? = null
    }

    class TestDataRes(status: Int, error: String, data: TestData) : ApiResponse<TestData>(status, error, data)
}