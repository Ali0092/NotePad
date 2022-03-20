package com.example.notepad.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.R
import com.example.notepad.adapter.ItemAdapter
import com.example.notepad.databinding.FragmentMainBinding
import com.example.notepad.viewModel.AppViewModel


class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding
    private val myAdapter by lazy { ItemAdapter() }
    private val myViewModel by activityViewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater,container,false)

        setUpRecyclerView()
        myViewModel.getAllItems()
        myViewModel.todos.observe(viewLifecycleOwner, Observer { it->
            myAdapter.getDataChanges(it)
        })

        binding.floatingActionButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }

        return binding.root
    }



    private fun setUpRecyclerView(){
        binding.recView.adapter=myAdapter
        binding.recView.layoutManager=LinearLayoutManager(requireContext())
    }


}