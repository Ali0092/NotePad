package com.example.notepad.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val body:String
) : Parcelable
