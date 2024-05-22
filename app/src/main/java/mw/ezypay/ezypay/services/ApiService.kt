package mw.ezypay.ezypay.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface EzyPayAPI {
    @POST("")
    @Headers("ApiKey: ")
    suspend fun add()
    companion object{
        private lateinit var retrofit: Retrofit
        fun init(): EzyPayAPI {
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .callTimeout(30,TimeUnit.SECONDS)
                .build()
            if(!Companion::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl("")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit.create(EzyPayAPI::class.java)
        }
    }
}