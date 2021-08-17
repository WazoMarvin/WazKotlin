package com.example.wazipay.welcome.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wazipay.data.User
import com.example.wazipay.helpers.storeAuthToken
import com.example.wazipay.network.WaziApi
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterFragmentViewModel(context: Context) : ViewModel() {
    var context = context;
    private val _registerSuccess = MutableLiveData<Boolean>()
    val registerSuccess: LiveData<Boolean>
        get() = _registerSuccess

    private val _isRegistering = MutableLiveData<Boolean>()
    val isRegistering: LiveData<Boolean>
        get() = _isRegistering

    init {
        _isRegistering.value =false
        Log.d("is registering",_isRegistering.value.toString())
    }

    fun registerNewUser(name: String, email: String, password: String){
        if (_isRegistering.value==false){
            viewModelScope.launch {
                try {
                    _isRegistering.value =true
                    var newUser =  User(name, email, password);
                    var auth_token=  WaziApi.retrofitService.registerUser(newUser)
                    storeAuthToken(auth_token,context)
                    _registerSuccess.value = true;
                    _isRegistering.value =false;
                }catch (e : Exception){
                    Log.d("error",e.message.toString())
                }
            }
        }

    }


}