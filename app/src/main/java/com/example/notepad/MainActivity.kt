package com.example.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.adapter.ItemAdapter
import com.example.notepad.databinding.ActivityMainBinding
import com.example.notepad.model.Item
import com.example.notepad.viewModel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private lateinit var binding:ActivityMainBinding
   private val myAdapter by lazy { ItemAdapter() }
   private val myViewModel by viewModels<AppViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        val temp= Item(1,"Testing","This is the testing Symbol...")
        val temp1= Item(2,"Testing1","This is the testing Symbol...1")
        myViewModel.addItem(temp)
        myViewModel.addItem(temp1)

        myViewModel.todos.observe(this, Observer { atoms->
        myAdapter.getDataChanges(atoms)
        })


    }


    fun setUpRecyclerView(){
        binding.recView.adapter=myAdapter
        binding.recView.layoutManager=LinearLayoutManager(this)
    }

}