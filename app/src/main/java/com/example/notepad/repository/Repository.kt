package com.example.notepad.repository

import androidx.lifecycle.LiveData
import com.example.notepad.db.ItemDAO
import com.example.notepad.model.Item
import javax.inject.Inject

class Repository(private val getDao:ItemDAO) {

     suspend fun getAllItems():LiveData<List<Item>>{
       return getDao.getAllItems()
     }
    suspend fun addItem(item: Item){
        getDao.setItem(item)
    }

}