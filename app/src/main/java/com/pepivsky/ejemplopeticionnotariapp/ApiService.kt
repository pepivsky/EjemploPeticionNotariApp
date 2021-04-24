package com.pepivsky.ejemplopeticionnotariapp

import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.http.*

interface ApiService {

    @Multipart
    @POST("users/signup")
    //@FormUrlEncoded
    fun registerUser(
        @Part("person_type") personType: RequestBody,
        @Part("firstname") firstName: RequestBody,
        @Part("middlename") middleName: RequestBody,
        @Part("lastname") lasName: RequestBody,
        @Part("secondlastname") secondLastName: RequestBody,
        @Part("type_doc") typeDoc: RequestBody,
        @Part("num_doc") numDoc: RequestBody,
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
    )/*: Call<Respuesta>*/
}

/*
    @Multipart
    @POST
    @FormUrlEncoded
    fun registerUser(@Field part: MultipartBody,
                     @Field("person_type") personType: Int
    )
     */

/*@Multipart
@POST("http://3.219.19.170:3000/users/signup")
Call<ResponseBody> registerUser(@Part MultipartBody.Part image,
@Part("email") RequestBody email,
@Part("password") RequestBody password,
@Part("nombre") RequestBody nombre
);*/