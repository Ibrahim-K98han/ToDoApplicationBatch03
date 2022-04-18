package com.example.todoapplicationbatch03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationbatch03.databinding.FragmentLoginBinding
import com.example.todoapplicationbatch03.entity.LoginViewModel
import com.example.todoapplicationbatch03.entity.UserModel
import com.example.todoapplicationbatch03.prefsdata.LoginPreference
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private val loginViewModel:LoginViewModel by activityViewModels()
    private lateinit var preference: LoginPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preference = LoginPreference(requireContext())
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        loginViewModel.errMsgLD.observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        }
        binding.loginBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()
            //TODO: validate field
            loginViewModel.login(email,password){
                lifecycle.coroutineScope.launch {
                    preference.setLoginStatus(true,it,requireContext())
                    findNavController().popBackStack()
                }
            }
        }
        binding.registerBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.toString()
            //TODO: validate field
            val user = UserModel(email = email, password = password)
            loginViewModel.register(user){
                lifecycle.coroutineScope.launch {
                    preference.setLoginStatus(true,it,requireContext())
                    findNavController().popBackStack()
                }
            }
        }
        return binding.root
    }

}