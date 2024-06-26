package com.example.jetpackcomposeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.login.domain.usecases.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase.invoke(email.value!!, password.value!!)
            if(result) {
                //navegar a la otra pantalla
                Log.i("LoginViewModel", "Result ok")
            } else {
                Log.i("LoginViewModel", "Result MALMAL")
            }
            _isLoading.value = false
        }
    }
}
