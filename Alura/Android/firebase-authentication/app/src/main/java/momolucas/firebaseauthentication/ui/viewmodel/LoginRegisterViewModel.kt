package momolucas.firebaseauthentication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import momolucas.firebaseauthentication.model.Resource
import momolucas.firebaseauthentication.model.User
import momolucas.firebaseauthentication.repository.LoginRegisterRepository

class LoginRegisterViewModel(private val repository: LoginRegisterRepository) : ViewModel() {

    fun registerUser(user: User):LiveData<Resource<Boolean?>> = repository.registerUser(user)

    fun isLogged(): Boolean = repository.isLogged()

    fun singOut() = repository.signOut()

    fun singIn(user: User): LiveData<Resource<Boolean?>> = repository.signIn(user)

    fun getEmail(): LiveData<User> = repository.getEmail()
}