package com.beanworth.mvvmtut.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.beanworth.mvvmtut.data.repository.AuthRepository
import com.beanworth.mvvmtut.data.repository.BaseRepository
import com.beanworth.mvvmtut.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory( private val repository: BaseRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}