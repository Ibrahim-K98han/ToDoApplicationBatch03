package com.example.todoapplicationbatch03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapplicationbatch03.customedialog.DatePickerFragment
import com.example.todoapplicationbatch03.customedialog.TimePickerFragment
import com.example.todoapplicationbatch03.databinding.FragmentNewToDoBinding
import com.example.todoapplicationbatch03.entity.ToDoModel

class NewToDoFragment : Fragment() {

    private lateinit var binding:FragmentNewToDoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewToDoBinding.inflate(inflater,container,false)

        binding.dateBtn.setOnClickListener {
            DatePickerFragment{
                binding.dateTv.text = it
            }.show(childFragmentManager,null)
        }
        binding.timeBtn.setOnClickListener {
            TimePickerFragment{
                binding.timeTv.text = it
            }.show(childFragmentManager,null)
        }
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {

    }
}