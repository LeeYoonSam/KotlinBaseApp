package com.ys.albertbaseproject.network.dto

import com.google.gson.annotations.SerializedName

open class ApiResponse<T> {
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("error")
    var error: String? = null
    @SerializedName("data")
    var data: T? = null

    constructor(status: Int, error: String, data: T) {
        this.status = status
        this.error = error
        this.data = data
    }
}