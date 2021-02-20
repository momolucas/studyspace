package momolucas.firebaseauthentication.model

data class User(
    val email: String,
    val password: String,
) {
    fun validateUser(): Boolean = this.email.isNotBlank() && this.password.isNotBlank()
}