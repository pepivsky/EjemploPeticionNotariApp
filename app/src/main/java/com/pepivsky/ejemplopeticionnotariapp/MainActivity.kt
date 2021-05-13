package com.pepivsky.ejemplopeticionnotariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.pepivsky.ejemplopeticionnotariapp.adapter.TramiteAdapter
import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import com.pepivsky.ejemplopeticionnotariapp.response.emailcode.VerifyEmailResponse
import com.pepivsky.ejemplopeticionnotariapp.response.gettramites.GetTramitesResponse
import com.pepivsky.ejemplopeticionnotariapp.response.gettramites.GetTramitesResponseItem
import com.pepivsky.ejemplopeticionnotariapp.response.info.Document
import com.pepivsky.ejemplopeticionnotariapp.response.info.InfoResponse
import com.pepivsky.ejemplopeticionnotariapp.response.signin.SendCodeEmailResponse
import com.pepivsky.ejemplopeticionnotariapp.response.tramites.TramitesResponse
import com.pepivsky.ejemplopeticionnotariapp.response.tramites.TramitesResponseItem
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TramiteAdapter
    lateinit var recyclerTramites: RecyclerView


    companion object {
        fun getRetrofit(): Retrofit {
            val baseURL = "http://3.219.19.170:3000/"
            //http://3.219.19.170:3000/

            //objeto logger
            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            //HTTP client
            val client = OkHttpClient.Builder().addInterceptor(logger)

            //objeto builder
            val builder = Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                //agregando el cliente http
                .client(client.build())
            val retrofit = builder.build()
            Log.i("companion", "Aqui ocurre")

            //objeto retrofit
            return retrofit
        }
    }

   // lateinit var documentTypesList: MutableList<Document>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("onCreate", "entrando en el metodo")
        //getTypes()
        //createUser()

        //verifyEmailCode()

       /* //verificando el telefono
        val baseURL = "https://notariappapi20210504175025.azurewebsites.net/api/Valid/" //url base OK
        //https://notariappapi20210504175025.azurewebsites.net/api/Valid/ValidSend/7731295070

        //objeto logger
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        //HTTP client
        val client = OkHttpClient.Builder().addInterceptor(logger)

        //objeto builder
        val builder = Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            //agregando el cliente http
            .client(client.build())
        val retrofit = builder.build()
        Log.i("companion", "Aqui ocurre")

        val call = retrofit.create(NotariService::class.java)
        call.sendPhoneCode("7731295070").enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    Log.i("Exito", "codigo: ${response.body()}")
                } else {
                    Log.i("mal", "Algo salio mal ${response.message()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i("bad", "Error $call")
            }

        })*/
        /*val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MjA0MTc1NjksImV4cCI6MTYyMDQyMTE2OX0.UNiT2bCy-6TugLAyjpv477M2WJyq7nXLEyVSa3NlgvE"
        getTramites(token)*/

            //verificar email





        //val baseURL = "http://3.219.19.170:3000/"
        //createUser()

/*
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
        val retrofit = builder.build()*/

        /*val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MjA4NTYzMjcsImV4cCI6MTYyMDg1OTkyN30.XK8dMNdQ9vVFBZaa-M19hp8QwpWg-HWWW698DXO02Vk"
        val id = "201"
        val email = "pepivsky@gmail.com"
        val typeSend = "1"

        sendCodeEmailLogin(token, id, email, typeSend)*/

        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MjA5MjM3MjgsImV4cCI6MTYyMDkyNzMyOH0.cU8MimHG-m9XV8_Ste9qiMmHOK_8SRPXZfPcerGPxcE"

        getPrincipalTramites(token)

    }

    private fun initRecyclerView(response: List<GetTramitesResponseItem>) {
        recyclerTramites = findViewById(R.id.rvTramites)
        val newList: List<GetTramitesResponseItem> = response

        newList.forEach {
            when (it.transact) {
                "Declaraciones" -> it.image = R.drawable.declaraciones
                "Registro Civil" -> it.image = R.drawable.registro
                "Escrituración" -> it.image = R.drawable.escrituras
                "Autenticación" -> it.image = R.drawable.autenticaciones
                "Conciliación" -> it.image = R.drawable.conciliaciones
                "Remates" -> it.image = R.drawable.remates

            }
        }


        adapter = TramiteAdapter(newList)
        recyclerTramites.layoutManager = GridLayoutManager(this,3)
        recyclerTramites.adapter = adapter
    }

    private fun getPrincipalTramites(token: String) {
        val retrofit = getRetrofit()
        val call = retrofit.create(NotariService::class.java)

        call.getTramites(token).enqueue(object : Callback<List<GetTramitesResponseItem>> {
            override fun onResponse(
                call: Call<List<GetTramitesResponseItem>>,
                response: Response<List<GetTramitesResponseItem>>
            ) {
                if (response.isSuccessful) {
                    Log.i("tramites", "response:${response.body()}")
                    response.body()?.let { initRecyclerView(it) }
                }
            }

            override fun onFailure(call: Call<List<GetTramitesResponseItem>>, t: Throwable) {
                Log.i("bad", "Algo salio mal $call")
            }

        })

    }

    private fun sendCodeEmailLogin(token: String, id: String, email: String, typeSend: String) {
        val retrofit = getRetrofit()
        val call = retrofit.create(NotariService::class.java)

        call.sendEmailCodeLogin(token, id, email, typeSend).enqueue(object : Callback<SendCodeEmailResponse> {
            override fun onResponse(
                call: Call<SendCodeEmailResponse>,
                response: Response<SendCodeEmailResponse>
            ) {
                if (response.isSuccessful) {
                    Log.i("enviarCodigo", "response:${response.body()}")
                } else {
                    Log.i("mal! : ", response.message())
                }

            }

            override fun onFailure(call: Call<SendCodeEmailResponse>, t: Throwable) {
                Log.i("bad", "Algo salio mal $call")
            }

        })
    }

    private fun getTramites(token: String) {
        val retrofit = getRetrofit()

        val call = retrofit.create(NotariService::class.java)
        call.getTramitesByToken(token).enqueue(object : Callback<TramitesResponse> {
            override fun onResponse(
                call: Call<TramitesResponse>,
                response: Response<TramitesResponse>
            ) {
                if (response.isSuccessful) {
                    Log.i("Exito!:", "${response.body()}")
                    Log.i("info:", "message:${response.body()}")
                } else {
                    Log.i("mal! : ", response.message())
                }
            }

            override fun onFailure(call: Call<TramitesResponse>, t: Throwable) {
                Log.i("bad", "Algo salio mal $call")
            }

        })
    }

    private fun verifyEmailCode() {
        val retrofit = getRetrofit()
        val call = retrofit.create(NotariService::class.java)
        call.verifyEmailCode("elmacho@gmail.com", "123456")
            .enqueue(object : Callback<VerifyEmailResponse> {
                override fun onResponse(
                    call: Call<VerifyEmailResponse>,
                    response: Response<VerifyEmailResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("Exito!:", "${response.body()}")
                        Log.i("info:", "message:${response.body()?.message} id: ${response.body()?.id} email: ${response.body()?.email}")
                    } else {
                        Log.i("mal! : ", response.message())
                    }
                }

                override fun onFailure(call: Call<VerifyEmailResponse>, t: Throwable) {
                    Log.i("bad", "Algo salio mal $call")
                }

            })
    }

    /*private fun setupSpinner(list: List<Document?>) {
        Log.i("lista" , "$list")
        val listLocal = listOf("pepe", "problemas")
        val spinner: Spinner = findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            list
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.prompt = "Selecciona";
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Snackbar.make(spinner, "Las contrasenas deben coincidir", Snackbar.LENGTH_SHORT).show()
                Log.i("TAG", "Clic")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Toast.makeText(this@MainActivity, "Nada", Toast.LENGTH_LONG).show()
            }

        }
    }*/

   /* fun getTypes() {
        val typesDocList = mutableListOf<Document?>()
        val retrofit = getRetrofit()
        val call = retrofit.create(NotariService::class.java)

        call.getRegisterInfo().enqueue(object : Callback<InfoResponse> {
            override fun onResponse(
                call: Call<InfoResponse>,
                response: Response<InfoResponse>
            ) {
                if (response.isSuccessful) {
                    Log.i("Exito! : ", "${response.body()}")

                    Log.i("document", "${response.body()?.documents}")

                    typesDocList.addAll(response.body()?.documents!!)
                    setupSpinner(typesDocList)

                } else {
                    Log.i("mal! : ", response.message())
                }
            }

            override fun onFailure(call: Call<InfoResponse>, t: Throwable) {
                Log.i("bad", "Algo salio mal")
            }

        })

    }*/

    /*fun createUser() {
        //haciendo la peticion
        Log.i("onCreate", "Haciendo la peticion")
        val retrofit = getRetrofit()
        val call =
            retrofit.create(NotariService::class.java) //pasandole la interfaz que contiene los endpoints
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
        ).enqueue(object : Callback<Respuesta> {
            override fun onResponse(call: Call<Respuesta>, response: Response<Respuesta>) {
                if (response.isSuccessful) {
                    Log.i("Exito! : ", "${response.body()}")
                    Log.i("codigo! : ", "${response.body()?.body?.user?.code}")

                } else {
                    Log.i("else", ":(")
                }
            }

            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                Log.i("bad", "Algo salio mal")
            }

        })
    }*/
}