package com.example.notepad.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notepad.R
import com.example.notepad.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private lateinit var binding:FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentUpdateBinding.inflate(inflater,container,false)

        return binding.root
    }

}