package mw.ezypay.ezypay.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

object NetworkUtils {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> T
    ): Result<T> {
        return withContext(dispatcher) {
            try {
                Result.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Result.failure(NetworkError.IOError(throwable))
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        Result.failure(NetworkError.HttpError(code, errorResponse))
                    }
                    else -> Result.failure(NetworkError.UnknownError(throwable))
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): String? {
        return try {
            throwable.response()?.errorBody()?.string()
        } catch (exception: Exception) {
            null
        }
    }

    sealed class NetworkError : Throwable() {
        data class IOError(val exception: IOException) : NetworkError()
        data class HttpError(val code: Int, val errorResponse: String?) : NetworkError()
        data class UnknownError(val exception: Throwable) : NetworkError()
    }
}