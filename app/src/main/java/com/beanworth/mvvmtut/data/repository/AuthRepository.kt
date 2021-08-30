package com.beanworth.mvvmtut.data.repository

import com.beanworth.mvvmtut.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        phone: String,
        password: String
    ) = safeApiCall {
        api.login(phone, password)
    }

}