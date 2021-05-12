package com.pepivsky.ejemplopeticionnotariapp.response.emailcode

data class VerifyEmailResponse(
    val email: String,
    val email_verified: Int,
    val id: String,
    val message: String,
    val phonecode: String,
    val status: String
)