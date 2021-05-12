package com.pepivsky.ejemplopeticionnotariapp.response.info

data class Document(
    //val created_at: String,

    val id: String,
    val name: String,
    val descripton: String
    //val status: Int,
    //val updated_at: String
) {
    override fun toString(): String {
        return "$descripton $name"
    }
}