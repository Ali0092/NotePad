package com.example.notepad.viewModel

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

   private val _item=MutableLiveData<Item>()
           val item:MutableLiveData<Item>
           get() = _item

    init {
        _item.value=Item(1," "," ")
    }

    fun addItem(item: Item){
       viewModelScope.launch {
         _item.value=item
         repo.addItem(item)
       }
    }

    fun getItems(){
        viewModelScope.launch {
            repo.getAllItems()
        }
    }


}