package com.example.notepad.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notepad.model.Item

@Dao
interface ItemDAO {

    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun setItem(item: Item)

    @Update
    suspend fun updateItem(item:Item)

    @Delete
    suspend fun deleteItem(item:Item)

    @Query("SELECT*FROM ITEM_TABLE")
    fun getAllItems():LiveData<List<Item>>
}