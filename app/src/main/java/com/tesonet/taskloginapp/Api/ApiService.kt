package com.tesonet.taskloginapp.Api

import com.tesonet.taskloginapp.models.Constants
import com.tesonet.taskloginapp.models.LoginRequest
import com.tesonet.taskloginapp.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

}