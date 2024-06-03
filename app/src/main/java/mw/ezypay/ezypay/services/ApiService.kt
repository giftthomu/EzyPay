package mw.ezypay.ezypay.services

import mw.ezypay.ezypay.common.ApiConstants
import mw.ezypay.ezypay.data.responses.EzyPayApiResponse
import mw.ezypay.ezypay.data.requets.LoginRequest
import mw.ezypay.ezypay.data.requets.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(ApiConstants.LOGIN_ENDPOINT)
    suspend fun login(@Body loginRequest: LoginRequest): EzyPayApiResponse

    @POST(ApiConstants.REGISTER_ENDPOINT)
    suspend fun register(@Body registerRequest: RegisterRequest): EzyPayApiResponse

   /* @GET("user/profile")
    suspend fun getUserProfile(@Header("Authorization") token: String): UserProfileResponse

    @GET("transactions")
    suspend fun getTransactions(@Header("Authorization") token: String): TransactionResponse

    @GET("payment_methods")
    suspend fun getPaymentMethods(@Header("Authorization") token: String): PaymentMethodsResponse

    @POST("payments")
    suspend fun makePayment(@Header("Authorization") token: String, @Body paymentRequest: PaymentRequest): PaymentResponse*/
}