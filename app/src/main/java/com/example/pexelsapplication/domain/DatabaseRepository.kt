package com.example.pexelsapplication.domain

import com.example.pexelsapplication.Data.models.Photo

interface DatabaseRepository {

    suspend fun getPhotoById(id: Int): PhotoDomain?

    suspend fun getPhotosList(): List<PhotoDomain>

    suspend fun addFavouritePhoto(photo: Photo)

    suspend fun removeFavouritePhoto(photo: Photo)

    suspend fun countPhotosById(id: Int): Int
}