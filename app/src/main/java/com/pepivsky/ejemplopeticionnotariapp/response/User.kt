package com.pepivsky.ejemplopeticionnotariapp.response

data class User(
    val id: String,
    val email: String,
    val email_verified: Int,
    val firstname: String,
    val code: String
)