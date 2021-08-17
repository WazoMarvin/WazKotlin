package com.example.wazipay.helpers

import android.content.Context
import android.content.SharedPreferences

fun storeAuthToken(auth_token: String, context: Context){
    val sharedPreference =  context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
    var editor = sharedPreference.edit()
    editor.putString("auth_token",auth_token)
    editor.commit()
}