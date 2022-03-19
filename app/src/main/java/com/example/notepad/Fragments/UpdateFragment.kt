package com.example.notepad.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.notepad.R
import com.example.notepad.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private lateinit var binding:FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentUpdateBinding.inflate(inflater,container,false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_menu,menu)
    }

}