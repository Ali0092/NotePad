package com.example.notepad.Fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.notepad.R
import com.example.notepad.databinding.FragmentAddBinding
import com.example.notepad.model.Item
import com.example.notepad.viewModel.AppViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val myViewModel by activityViewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)

            val onBackPressedCallback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    myViewModel.addItem(addItem())

                   findNavController().navigate(R.id.action_addFragment_to_mainFragment)
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                onBackPressedCallback
            )

        return binding.root
    }

    private fun addItem(): Item {
        val id = (1..100).random()
        val title = binding.titleEt.text.toString()
        val body = binding.bodyEt.text.toString()

        return if(!(title.isNullOrEmpty() && body.isNullOrEmpty()))
            Item(id, title, body)
        else{
            Toast.makeText(context,"NUll Found",Toast.LENGTH_LONG).show()
            Item(0,"Black","Flag")
        }

    }
}