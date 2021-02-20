package momolucas.firebaseauthentication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register_user.*
import momolucas.firebaseauthentication.R
import momolucas.firebaseauthentication.extensions.showToast
import momolucas.firebaseauthentication.model.User
import momolucas.firebaseauthentication.ui.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RegisterUserFragment : Fragment() {

    private val navContoller by lazy { findNavController() }
    private val loginRegisterViewModel: LoginRegisterViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        btn_cadastrar.setOnClickListener {
            if (validateForm())
                loginRegisterViewModel.registerUser(
                    User(
                        text_input_email.text.toString(),
                        text_input_senha.text.toString()
                    )
                ).observe(viewLifecycleOwner, Observer { livedata ->
                    livedata.data?.let {
                        if (it) {
                            showToast("Cadastrado com sucesso", requireContext())
                            navContoller.navigateUp()
                        } else showToast("${livedata.error}", requireContext())
                    }
                    livedata.error?.let { error ->
                        showToast(error, requireContext())
                    }
                })
        }
    }

    private fun validateForm(): Boolean {
        return when {
            !validadePassword() -> {
                layout_text_input_senha.error = "Senhas não conferem"
                layout_text_input_confirma_senha.error = "Senhas não conferem"
                false
            }
            text_input_email.text.isNullOrBlank() -> {
                layou_text_input_email.error = "Campo de email obrigatório"
                false
            }
            else -> true
        }
    }

    private fun validadePassword(): Boolean {
        return text_input_senha.text.toString() == text_input_confirma_senha.text.toString()
    }
}