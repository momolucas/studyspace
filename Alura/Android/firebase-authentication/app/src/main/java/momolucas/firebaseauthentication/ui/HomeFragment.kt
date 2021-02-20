package momolucas.firebaseauthentication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_home.*
import momolucas.firebaseauthentication.R
import momolucas.firebaseauthentication.ui.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment() {

    lateinit var btnLogout: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        btnLogout = view.findViewById(R.id.btn_logOut)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        btnLogout.setOnClickListener {
            loginRegisterViewModel.singOut()
            navToLogin()
        }
        loginRegisterViewModel.getEmail().observe(viewLifecycleOwner, Observer {
            textView.text = it.email
        })
    }


}