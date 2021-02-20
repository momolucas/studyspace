package momolucas.firebaseauthentication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import momolucas.firebaseauthentication.NavGraphDirections
import momolucas.firebaseauthentication.R
import momolucas.firebaseauthentication.ui.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment : Fragment() {

    protected val loginRegisterViewModel: LoginRegisterViewModel by sharedViewModel()
    private val navContoller by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isLogged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    private fun isLogged() {
        if (!loginRegisterViewModel.isLogged()) navToLogin()
    }

    protected fun navToLogin(){
        navContoller.navigate(NavGraphDirections.globalActionLogin())
    }
}