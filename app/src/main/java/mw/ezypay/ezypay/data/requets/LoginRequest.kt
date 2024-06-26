package mw.ezypay.ezypay.data.requets

data class LoginRequest(
    val phone: String?,
    val email: String?,
    val password:String
){
 init {
     require(!email.isNullOrBlank() || !phone.isNullOrBlank()){
         "Either email or phone must be provided."
     }
 }
}
