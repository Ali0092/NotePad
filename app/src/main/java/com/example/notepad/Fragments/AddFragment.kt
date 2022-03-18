package com.example.notepad.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notepad.R
import com.example.notepad.databinding.FragmentAddBinding
import com.example.notepad.databinding.FragmentMainBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAddBinding.inflate(inflater,container,false)

        //Adding data in ROOM....
        return binding.root
    }

}