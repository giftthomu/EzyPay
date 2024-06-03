package mw.ezypay.ezypay.data.requets

data class RegisterRequest(
    val email:String,
    val firstName:String,
    val lastName:String,
    val password:String
)