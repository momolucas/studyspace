package momolucas.firebaseauthentication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login_user.*
import momolucas.firebaseauthentication.R
import momolucas.firebaseauthentication.extensions.showToast
import momolucas.firebaseauthentication.model.User
import momolucas.firebaseauthentication.ui.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginUserFragment : Fragment() {

    private val navController by lazy { findNavController() }
    private val loginRegisterViewModel: LoginRegisterViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        btn_singIn.setOnClickListener {
            val user = User(
                email = input_login_email.text.toString(),
                password = input_login_password.text.toString()
            )
            if (user.validateUser()) {
                loginRegisterViewModel.singIn(user).observe(viewLifecycleOwner, Observer {
                    it?.let { response ->
                        if (response.data == true) {
                            navigateToHomeFragment()
                        } else {
                            showToast(response.error.toString(), requireContext())
                        }
                    }
                })
            } else {
                showToast("Credencias inválidas", requireContext())
            }
        }
        btn_register.setOnClickListener {
            navController.navigate(
                LoginUserFragmentDirections.actionLoginUserFragmentToRegisterUserFragment()
            )
        }
    }

    private fun navigateToHomeFragment() =
        navController.navigate(LoginUserFragmentDirections.actionLoginToHomeFragment())

}