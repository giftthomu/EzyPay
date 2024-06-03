package mw.ezypay.ezypay.data.responses

data class EzyPayApiResponse(
    val statusCode: Int,
    val remark: String,
    val data: Data,
    val errors: List<Errors>
)
data class Errors(
    val errorCode: Int,
    val fieldName: String,
    val errorMessage: String
)

data class Data(
    val data: String
)