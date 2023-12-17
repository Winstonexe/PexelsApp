package com.example.pexelsapplication.Data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pexelsapplication.Data.models.Photo
import com.example.pexelsapplication.app.di.Dao

@Database(entities = [Photo::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {
    abstract val dao: Dao
}