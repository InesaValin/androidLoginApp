package com.tesonet.taskloginapp.models

data class LoginResponse (val status_code: Int, val auth_token: String, val user: User)