package com.pepivsky.ejemplopeticionnotariapp

import com.pepivsky.ejemplopeticionnotariapp.response.Respuesta
import com.pepivsky.ejemplopeticionnotariapp.response.emailcode.VerifyEmailResponse
import com.pepivsky.ejemplopeticionnotariapp.response.info.InfoResponse
import com.pepivsky.ejemplopeticionnotariapp.response.signin.SendCodeEmailResponse
import com.pepivsky.ejemplopeticionnotariapp.response.tramites.TramitesResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


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
        @Field("dpto") dpto: String,
        @Field("city") city: String,
        @Field("address") address: String,
        @Field("email") email: String,
        @Field("confirm_email") confirmEmail: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String

        ): Call<Respuesta> //devuelve un objeto Respuesta

    @POST("users/signup") //metodo post con su url
    @FormUrlEncoded //post de tipo:  x-www-form-urlencoded
    fun createNormalPerson(
        @Field("person_type") personType: String,
        @Field("firstname") firstName: String,
        @Field("middlename") middleName: String,
        @Field("lastname") lastName: String,
        @Field("secondlastname") secondLastName: String,
        @Field("type_doc") typeDoc: String,
        @Field("num_doc") numDoc: String,
        @Field("birthday") birthDay: String,
        @Field("dpto") dpto: String,
        @Field("city") city: String,
        @Field("address") address: String,
        @Field("email") email: String,
        @Field("confirm_email") confirmEmail: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String

    ): Call<Respuesta> //devuelve un objeto Respuesta


    @GET("register/info")
    fun getRegisterInfo(): Call<InfoResponse>


   // val baseURL = "https://notariappapi20210504175025.azurewebsites.net/api/Valid/ValidSend/"
    //https://notariappapi20210504175025.azurewebsites.net/api/Valid/ValidSend/7731295070
    @GET("ValidSend/{phone}")
    fun sendPhoneCode(@Path("phone")phone: String):Call<String>

    //"http://3.219.19.170:3000/register/validate/emailcode"
    @PUT("register/validate/emailcode")
    @FormUrlEncoded
    fun verifyEmailCode(
        @Field("email") email: String,
        @Field("code") code: String
    ): Call<VerifyEmailResponse>

    @GET("members/transact/new/1")
    fun getTramitesByToken(@Header("Authorization")token: String): Call<TramitesResponse>

    // verificacion despues del login
    @POST("users/signin/verifycode")
    @FormUrlEncoded
    fun sendEmailCodeLogin(
        @Header("Authorization") token: String,
        @Field("id") id: String,
        @Field("email") email: String,
        @Field("type_send") typeSend: String
    ):Call<SendCodeEmailResponse>

}
