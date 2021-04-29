package com.pepivsky.ejemplopeticionnotariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseURL = "http://3.219.19.170:3000/"

        //objeto logger
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        //HTTP client
        val client = OkHttpClient.Builder().addInterceptor(logger)

        //objeto builder
        val builder = Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
        //agregando el cliente http
            .client(client.build())

        //objeto retrofit
        val retrofit = builder.build()

        //haciendo la peticion
        Log.i("onCreate", "Haciendo la peticion")
        val call = retrofit.create(NotariService::class.java) //pasandole la interfaz que contiene los endpoints
        //llamando al metodo y pasandole la informacion
        call.createUser(
            "1",
            "Shiro",
            "manuel",
            "paredes",
            "ramirez",
            "1",
            "2131232",
            "1997-03-05",
            "213123131",
            "algo",
            "7731295070",
            "sdlkajsdlkajkdl",
            "barranquilla",
            "vivo en alguna parte",
            "pepe@gmail.com",
            "pepe@gmail.com",
            "pepe1997A_",
            "pepe1997A_"
        ).enqueue(object : Callback<Respuesta>{
            override fun onResponse(call: Call<Respuesta>, response: Response<Respuesta>) {
                if (response.isSuccessful) {
                    Log.i("Exito! : ", "${response.body()}")
                } else {
                    Log.i("else", ":(")
                }
            }

            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                Log.i("bad", "Algo salio mal")
            }

        })
    }
}