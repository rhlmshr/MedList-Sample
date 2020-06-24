package com.medcords.sample.network.models

class BaseResponse<T: Any> {
    var status: Int? = null
    var message: String? = null
    var data: T? = null
}