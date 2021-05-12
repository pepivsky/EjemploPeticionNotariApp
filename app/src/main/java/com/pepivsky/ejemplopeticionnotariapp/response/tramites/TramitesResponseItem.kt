package com.pepivsky.ejemplopeticionnotariapp.response.tramites

data class TramitesResponseItem(
    val `annotation`: Any,
    val service: String,
    val service_id: String,
    val status: Int
)