package momolucas.firebaseauthentication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import momolucas.firebaseauthentication.R

class MainActivity : AppCompatActivity() {

    private val firebaseAuth by lazy { Firebase.auth }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val currentUser = firebaseAuth.currentUser
//        currentUser?.let {
//            Toast.makeText(this, "Usuário ${currentUser.email} logado", Toast.LENGTH_LONG).show()
//            logout()
//        } ?: login()
    }

    private fun createUser() {

    }

    private fun login() {
//        val task = firebaseAuth.signInWithEmailAndPassword("teste@email.com", "as12as12")
//        task.addOnSuccessListener {
//            Toast.makeText(this, "Usuário logado", Toast.LENGTH_LONG).show()
//        }
//        task.addOnFailureListener {
//            Toast.makeText(this, "Erro ao logar", Toast.LENGTH_LONG).show()
//        }
    }

    private fun logout() {
        firebaseAuth.signOut()
    }
}