package com.example.notepad.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notepad.model.Item

@Dao
interface ItemDAO {

    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun setItem(item: Item)

    @Query("SELECT*FROM ITEM_TABLE")
    fun getAllItems():LiveData<List<Item>>
}