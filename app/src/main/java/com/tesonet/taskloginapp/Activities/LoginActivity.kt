package com.tesonet.taskloginapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tesonet.taskloginapp.Api.ApiClient
import com.tesonet.taskloginapp.R
import com.tesonet.taskloginapp.Storage.SessionManager
import com.tesonet.taskloginapp.models.LoginRequest
import com.tesonet.taskloginapp.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService().login(LoginRequest(username = "tesonet", password = "partyanimal"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val loginResponse = response.body()

                    if (loginResponse?.status_code == 200 && loginResponse.user != null) {
                        sessionManager.saveAuthToken(loginResponse.auth_token)
                    } else {
                        // Error logging in
                    }
                }
            })

    }
}