package mw.ezypay.ezypay.services

import mw.ezypay.ezypay.data.requets.LoginRequest
import mw.ezypay.ezypay.data.requets.RegisterRequest
import mw.ezypay.ezypay.data.responses.EzyPayApiResponse
import javax.inject.Inject

class AuthService @Inject constructor(private val apiService: ApiService) {

    suspend fun login(email: String, password: String): EzyPayApiResponse {
        val loginRequest = LoginRequest(email, password)
        return apiService.login(loginRequest)
    }

    suspend fun register(email: String, firstName: String,lastName:String, password: String): EzyPayApiResponse {
        val registerRequest = RegisterRequest(email, firstName, lastName , password)
        return apiService.register(registerRequest)
    }
}