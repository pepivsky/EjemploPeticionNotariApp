package com.pepivsky.ejemplopeticionnotariapp

import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {
/*
   // @Multipart
    @POST("users/signup")
    //@FormUrlEncoded
    fun registerUser(
        @Part() personType: RequestBody,
        @Part("firstname") firstName: RequestBody,
        @Part("middlename") middleName: RequestBody,
        @Part("lastname") lasName: RequestBody,
        @Part("secondlastname") secondLastName: RequestBody,
        @Part("type_doc") typeDoc: RequestBody,
        @Part("num\"person_type\"_doc") numDoc: RequestBody,
        @Part("birthday") birthDay: RequestBody,
        @Part("nit") nit: RequestBody,
        @Part("company_name") companyName: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("dpto") dpto: RequestBody,
        @Part("city") city: RequestBody,
        @Part("address") address: RequestBody,
        @Part("email") email: RequestBody,
        @Part("confirm_email") ConfirmEmail: RequestBody,
        @Part("password") password: RequestBody,
        @Part("confirm_password") confirmPassword: RequestBody
    ) Call<Respuesta>*/
}

interface NotariService {

    @POST("users/signup") //metodo post con su url
    @FormUrlEncoded //post de tipo:  x-www-form-urlencoded
    fun createUser(
        @Field("person_type") personType: String,
        @Field("firstname") firstName: String,
        @Field("middlename") middleName: String,
        @Field("lastname") lastName: String,
        @Field("secondlastname") secondLastName: String,
        @Field("type_doc") typeDoc: String,
        @Field("num_doc") numDoc: String,
        @Field("birthday") birthDay: String,
        @Field("nit") nit: String,
        @Field("company_name") companyName: String,
        @Field("phone") phone: String,
        @Field("dpto") dpto: String,
        @Field("city") city: String,
        @Field("address") address: String,
        @Field("email") email: String,
        @Field("confirm_email") confirmEmail: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String

        ): Call<Respuesta> //devuelve un objeto Respuesta
}
