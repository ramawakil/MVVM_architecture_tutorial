package com.beanworth.mvvmtut.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.beanworth.mvvmtut.R
import com.beanworth.mvvmtut.databinding.FragmentLoginBinding
import com.beanworth.mvvmtut.data.network.AuthApi
import com.beanworth.mvvmtut.data.network.Resource
import com.beanworth.mvvmtut.data.repository.AuthRepository
import com.beanworth.mvvmtut.ui.base.BaseFragment

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer{
            when (it) {
                is Resource.Success -> { Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }

                is Resource.Failure -> { Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_SHORT).show() }
            }
        })

        binding.loginButton.setOnClickListener{
            val phone = binding.usernameTextInput.text.toString().trim()
            val password = binding.passwordTextInput.text.toString().trim()

            //@todo add input validations
            viewModel.login(phone, password)
        }

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))

}