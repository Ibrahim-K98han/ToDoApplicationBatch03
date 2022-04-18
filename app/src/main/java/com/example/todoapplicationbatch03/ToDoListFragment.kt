package com.example.todoapplicationbatch03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationbatch03.databinding.FragmentToDoListBinding
import com.example.todoapplicationbatch03.prefsdata.LoginPreference
import kotlinx.coroutines.flow.collect

class ToDoListFragment : Fragment() {

    private lateinit var binding:FragmentToDoListBinding
    private lateinit var preference:LoginPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preference = LoginPreference(requireContext())
        preference.isLoggedInFlow.asLiveData().observe(viewLifecycleOwner){
            if(!it){
                findNavController()
                    .navigate(R.id.action_toDoListFragment_to_loginFragment)
            }
        }
        binding = FragmentToDoListBinding.inflate(inflater,container,false)

        binding.newToDoFab.setOnClickListener {
            findNavController()
                .navigate(R.id.action_toDoListFragment_to_newToDoFragment)
        }
        return binding.root
    }

}