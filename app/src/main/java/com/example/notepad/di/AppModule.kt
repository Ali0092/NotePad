package com.example.notepad.di

import android.content.Context
import androidx.room.Room
import com.example.notepad.db.AppDB
import com.example.notepad.db.ItemDAO
import com.example.notepad.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getDAO(db:AppDB):ItemDAO=db.getDao()

    @Provides
    @Singleton
    fun getDB(@ApplicationContext context: Context):AppDB= Room.databaseBuilder(
        context,
        AppDB::class.java,
        "Items_DataBase"
    ).build()

    @Provides
    @Singleton
    fun getRepo(dao:ItemDAO):Repository=Repository(dao)


}