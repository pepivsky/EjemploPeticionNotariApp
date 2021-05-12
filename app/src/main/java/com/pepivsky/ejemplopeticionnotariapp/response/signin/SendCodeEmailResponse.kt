package com.pepivsky.ejemplopeticionnotariapp.response.signin

data class SendCodeEmailResponse(
    val email: String,
    val id: String,
    val message: String,
    val phone: String,
    val status: String
)