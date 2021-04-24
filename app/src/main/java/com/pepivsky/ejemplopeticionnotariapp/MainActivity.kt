package com.pepivsky.ejemplopeticionnotariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TYPE_MULTIPART: MediaType? = "multipart/form-data".toMediaTypeOrNull()

        val call = getRetrofit().create(ApiService::class.java)
            .registerUser(
                RequestBody.create(TYPE_MULTIPART, "1"),
                RequestBody.create(TYPE_MULTIPART, "josepruebapepe"),
                RequestBody.create(TYPE_MULTIPART, "manuel"),
                RequestBody.create(TYPE_MULTIPART, "paredes"),
                RequestBody.create(TYPE_MULTIPART, "ramirez"),
                RequestBody.create(TYPE_MULTIPART, "1"),
                RequestBody.create(TYPE_MULTIPART, "34534534345"),
                RequestBody.create(TYPE_MULTIPART, "1980-01-05"),
                RequestBody.create(TYPE_MULTIPART, "9004585222"),
                RequestBody.create(TYPE_MULTIPART, "sometido Itda"),
                RequestBody.create(TYPE_MULTIPART, "3015648975"),
                RequestBody.create(TYPE_MULTIPART, "casanare"),
                RequestBody.create(TYPE_MULTIPART, "pradera"),
                RequestBody.create(TYPE_MULTIPART, "Av siempre viva"),
                RequestBody.create(TYPE_MULTIPART, "marcos2@gmail.com"),
                RequestBody.create(TYPE_MULTIPART, "marcos2@gmail.com"),
                RequestBody.create(TYPE_MULTIPART, "automan123Q."),
                RequestBody.create(TYPE_MULTIPART, "automan123Q.")
            )





        // Log.i("usuarioGuardado", response.toString())

        //Log.i("guardado", "${call.toString()} $call")


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://3.219.19.170:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    /*
    "users/signup",
                null,
                1,
                "jose",
                "manuel",
                "paredes",
                "ramirez",
                1,
                "34534534345",
                "1980-01-05",
                "9004585222",
                "sometido Itda",
                "3015648975",
                "casanare",
                "pradera",
                "Av siempre viva",
                "marcos2@gmail.com",
                "marcos2@gmail.com",
                "automan123Q.",
                "automan123Q.")
     */
}