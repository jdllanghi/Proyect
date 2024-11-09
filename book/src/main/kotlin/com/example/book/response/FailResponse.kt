package com.example.book.response

data class FailResponse(
    val status: String = "fail",
    val data: Any? = null
)