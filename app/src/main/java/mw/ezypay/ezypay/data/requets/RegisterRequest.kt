package mw.ezypay.ezypay.data.requets

data class RegisterRequest(
    val firstName:String,
    val lastName:String,
    val email:String,
    val phone: String,
    val password:String
)