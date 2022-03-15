package com.example.notepad.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.model.Item


@Database(entities = [Item::class], version = 1)
abstract class AppDB :RoomDatabase(){

    abstract fun getDao():ItemDAO
}