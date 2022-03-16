package com.example.notepad.repository

import androidx.lifecycle.LiveData
import com.example.notepad.db.ItemDAO
import com.example.notepad.model.Item
import javax.inject.Inject

class Repository(private val getDao:ItemDAO) {

    suspend fun addItem(item: Item){
        getDao.setItem(item)
    }

   fun getAllItems():LiveData<List<Item>> = getDao.getAllItems()

}