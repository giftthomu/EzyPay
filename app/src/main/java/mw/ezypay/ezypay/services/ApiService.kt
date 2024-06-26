package mw.ezypay.ezypay.services

import mw.ezypay.ezypay.common.ApiConstants
import mw.ezypay.ezypay.data.responses.EzyPayApiResponse
import mw.ezypay.ezypay.data.requets.LoginRequest
import mw.ezypay.ezypay.data.requets.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST(ApiConstants.LOGIN_ENDPOINT)
    suspend fun login(@Body loginRequest: LoginRequest): EzyPayApiResponse

    @POST(ApiConstants.REGISTER_ENDPOINT)
    suspend fun register(@Body registerRequest: RegisterRequest): EzyPayApiResponse

   @GET(ApiConstants.USER_PROFILE_ENDPOINT)
    suspend fun getUserProfile(@Header("Authorization") token: String): EzyPayApiResponse

    @GET(ApiConstants.TRANSACTIONS_ENDPOINT)
    suspend fun getTransactions(@Header("Authorization") token: String): EzyPayApiResponse

    @GET(ApiConstants.PAYMENT_METHODS_ENDPOINT)
    suspend fun getPaymentMethods(@Header("Authorization") token: String): EzyPayApiResponse

    @POST(ApiConstants.TRANSACTIONS_ENDPOINT)
    suspend fun makePayment(@Header("Authorization") token: String): EzyPayApiResponse
}