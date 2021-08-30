package com.beanworth.mvvmtut.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beanworth.mvvmtut.data.network.Resource
import com.beanworth.mvvmtut.data.repository.AuthRepository
import com.beanworth.mvvmtut.data.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        phone: String,
        password: String
    ) = viewModelScope.launch {
         _loginResponse.value = repository.login(phone, password)
    }

}