package com.example.notepad.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepad.model.Item
import com.example.notepad.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel
@Inject constructor(private val repo: Repository) : ViewModel() {

  var todos: LiveData<List<Item>>

  init {
      todos =repo.getAllItems()
  }
      fun getAllItems(){
       todos =repo.getAllItems()
      }

    fun addItem(item: Item){
       viewModelScope.launch {
         repo.addItem(item)
       }
    }

    fun updateItem(item: Item){
        viewModelScope.launch {
            repo.updateItem(item)
        }
    }

    fun deleteItem(item: Item){
        viewModelScope.launch {
            repo.deleteItem(item)
        }
    }


}