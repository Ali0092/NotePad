package com.example.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.adapter.ItemAdapter
import com.example.notepad.databinding.ActivityMainBinding
import com.example.notepad.viewModel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private lateinit var binding:ActivityMainBinding
   private val myAdapter by lazy { ItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


}