package com.beanworth.mvvmtut.data.network

import com.beanworth.mvvmtut.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/token/")
    suspend fun login(
        @Field("phone") phone: String,
        @Field("password") password: String
    ) : LoginResponse



}