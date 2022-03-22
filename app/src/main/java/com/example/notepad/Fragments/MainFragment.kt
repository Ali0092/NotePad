package com.example.notepad.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.R
import com.example.notepad.adapter.ItemAdapter
import com.example.notepad.databinding.FragmentMainBinding
import com.example.notepad.viewModel.AppViewModel
import kotlin.system.exitProcess


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val myAdapter by lazy { ItemAdapter() }
    private val myViewModel by activityViewModels<AppViewModel>()

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        setUpRecyclerView()
        myViewModel.getAllItems()
        myViewModel.todos.observe(viewLifecycleOwner, Observer { it ->
            myAdapter.getDataChanges(it)
        })


        binding.floatingActionButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }

        binding.bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.lock -> {
                    Toast.makeText(context, "Lock", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.theme -> {
                    binding.recView.setBackgroundColor(Color.BLACK)
                    Toast.makeText(context, "Theme", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Toast.makeText(context, "Aby Saaly..", Toast.LENGTH_SHORT).show()
                    true
                }
            }

        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                exitProcess(0)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
        return binding.root
    }

    //Setting up RecyclerView.....
    private fun setUpRecyclerView() {
        binding.recView.adapter = myAdapter
        binding.recView.layoutManager = LinearLayoutManager(requireContext())
    }


}