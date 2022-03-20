package com.example.notepad.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notepad.R
import com.example.notepad.databinding.FragmentUpdateBinding
import com.example.notepad.model.Item
import com.example.notepad.viewModel.AppViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding:FragmentUpdateBinding
    private val myViewModel by activityViewModels<AppViewModel>()
    private val arg by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentUpdateBinding.inflate(inflater,container,false)

        setHasOptionsMenu(true)

        binding.titleEt.setText(arg.currentItem.title.toString())
        binding.bodyEt.setText(arg.currentItem.body.toString())

        if(addItem().id!=0){
            val onBackPressedCallback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    myViewModel.updateItem(addItem())
                    findNavController().navigate(R.id.action_updateFragment_to_mainFragment)
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                onBackPressedCallback
            )
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.delete_item)
          delete()
        return true
    }

    private fun addItem(): Item {
        val id =arg.currentItem.id
        val title = binding.titleEt.text.toString()
        val body = binding.bodyEt.text.toString()

        return if(!(title.isNullOrEmpty() && body.isNullOrEmpty()))
            Item(id, title, body)
        else{
            Toast.makeText(context,"NUll Found", Toast.LENGTH_LONG).show()
            Item(0,"Black","Flag")
        }

    }

    private fun delete(){
        val builder=AlertDialog.Builder(context)
        builder.setPositiveButton("YES"){_,_->
            myViewModel.deleteItem(addItem())
         Toast.makeText(context,"Deleted...",Toast.LENGTH_LONG).show()
         this.findNavController().navigate(R.id.action_updateFragment_to_mainFragment)
        }
        builder.setNegativeButton("NO"){_,_->
            this.findNavController().navigate(R.id.action_updateFragment_to_mainFragment)
        }

        builder.setTitle("Delete!!")
        builder.setMessage("Are you sure you want to delete this item..!!")
        builder.create().show()
    }


}