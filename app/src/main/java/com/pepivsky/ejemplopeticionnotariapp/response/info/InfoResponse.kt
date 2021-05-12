package com.pepivsky.ejemplopeticionnotariapp.response.info

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("document")
    val documents: List<Document>,
    val dpts: List<Dpt>,
    @SerializedName("person_type")
    val personTypes: List<PersonType>
)