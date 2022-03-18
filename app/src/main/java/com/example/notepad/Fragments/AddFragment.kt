package com.example.notepad.Fragments

import android.app.ActionBar
import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notepad.R
import com.example.notepad.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAddBinding.inflate(inflater,container,false)

        setHasOptionsMenu(true)

        //Adding data in ROOM....
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_menu,menu)
    }

}