package mw.ezypay.ezypay.services

import mw.ezypay.ezypay.data.requets.LoginRequest
import mw.ezypay.ezypay.data.requets.RegisterRequest
import mw.ezypay.ezypay.data.responses.EzyPayApiResponse
import javax.inject.Inject

class AuthService @Inject constructor(private val apiService: ApiService) {

    suspend fun login(identifier: String, password: String): EzyPayApiResponse {
        val isEmail = identifier.contains("@")
        val loginRequest = if (isEmail) {
            LoginRequest(email = identifier, phone = null, password = password)
        } else {
            LoginRequest(email = null, phone = identifier, password = password)
        }
        return apiService.login(loginRequest)
    }

    suspend fun register(firstName: String,lastName:String,email: String, phone:String, password: String): EzyPayApiResponse {
        val registerRequest = RegisterRequest(firstName, lastName, email, phone, password)
        return apiService.register(registerRequest)
    }
}