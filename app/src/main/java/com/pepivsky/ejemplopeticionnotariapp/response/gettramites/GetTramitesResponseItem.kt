package com.pepivsky.ejemplopeticionnotariapp.response.gettramites

data class GetTramitesResponseItem(
    val description: Any,
    val id: String,
    val status: Int,
    val transact: String,
    var image: Int?
)