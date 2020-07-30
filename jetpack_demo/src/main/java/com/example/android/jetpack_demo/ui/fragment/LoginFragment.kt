package com.example.android.jetpack_demo.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.android.jetpack_demo.R
import com.example.android.jetpack_demo.libs.utils.Constants
import com.example.android.jetpack_demo.libs.utils.LogUtils
import com.example.android.jetpack_demo.libs.utils.PreferenceUtils
import com.example.android.jetpack_demo.libs.utils.ToastUtils
import com.example.android.jetpack_demo.model.LoginModel
import com.example.android.jetpack_demo.repository.LoginRepository
import com.example.android.jetpack_demo.ui.HomeActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProviders.of(requireActivity(), object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LoginModel(LoginRepository()) as T
            }

        })[LoginModel::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener {
            val username = usernameEdit.text?.trim().toString()
            val password = passwordEdit.text?.trim().toString()

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                ToastUtils.showToast(text = "please input username and password")
            } else {
                LogUtils.print(
                    LoginFragment::class.java.simpleName,
                    message = "login >>> username:$username  password:$password"
                )
                viewModel.login(username, password)
            }

        }
        registerBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        viewModel.loginState.observe(viewLifecycleOwner, Observer {
            if (it?.errorCode == 0) {
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
                var userId: Int by PreferenceUtils<Int>(Constants.KEY_USER_ID, -1)
                var userLogin: Boolean by PreferenceUtils<Boolean>(Constants.KEY_IS_LOGIN, true)
                var userName: String by PreferenceUtils<String>(Constants.KEY_USERNAME, "android")
                LogUtils.print(
                    tag = LoginFragment::class.java.simpleName,
                    message = "before >>> userId:$userId userName:$userName  userLogin:$userLogin  "
                )
                userId = it.data?.id!!
                userLogin = true
                userName = it.data?.username!!
                LogUtils.print(
                    tag = LoginFragment::class.java.simpleName,
                    message = "after >>> userId:$userId userName:$userName  userLogin:$userLogin  "
                )
                requireActivity()?.finish()


            } else {
                ToastUtils.showToast(text = it?.errorMsg!!)
            }
        })

    }
}