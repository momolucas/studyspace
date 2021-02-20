package momolucas.firebaseauthentication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import momolucas.firebaseauthentication.model.Resource
import momolucas.firebaseauthentication.model.User

class LoginRegisterRepository {

    private val firebaseAuth by lazy { Firebase.auth }

    fun registerUser(user: User): LiveData<Resource<Boolean?>> {
        val liveData = MutableLiveData<Resource<Boolean?>>()
        val task = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) liveData.value = Resource(true)
                else liveData.value = Resource(false, task.exception.toString())
            }
//        task.addOnSuccessListener {}
//        task.addOnFailureListener {}
        return liveData
    }

    fun isLogged(): Boolean = firebaseAuth.currentUser?.let { true } ?: false

    fun signOut() = firebaseAuth.signOut()

    fun signIn(user: User): LiveData<Resource<Boolean?>> {
        val liveData = MutableLiveData<Resource<Boolean?>>()
        firebaseAuth.signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                liveData.value = if (task.isSuccessful) {
                    Resource(true)
                } else {
                    val error = when (task.exception) {
                        is FirebaseAuthInvalidUserException,
                        is FirebaseAuthInvalidCredentialsException -> "Email e Senha incorretos"
                        else -> "Erro na autenticação!"
                    }
                    Resource(false, error)
                }
            }
        return liveData
    }

    fun getEmail(): LiveData<User> {
        val liveData = MutableLiveData<User>()
        firebaseAuth.currentUser?.let {
            liveData.value = User(it.email ?: "", "")
        }
        return liveData
    }

}