package com.example.pexelsapplication.app.di

import android.app.Application
import androidx.room.Room
import com.example.pexelsapplication.Constants.Constants.BASE_URL
import com.example.pexelsapplication.Data.DB.FavouritesDatabase
import com.example.pexelsapplication.Data.api.ApiService
import com.example.pexelsapplication.Data.repository.DatabaseRepositoryImpl
import com.example.pexelsapplication.Data.repository.NetworkDataRepositoryImpl
import com.example.pexelsapplication.domain.DataRepository
import com.example.pexelsapplication.domain.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkDataRepository(apiService: ApiService): DataRepository {
        return NetworkDataRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideFavouritesDatabase(app: Application): FavouritesDatabase {
        return Room.databaseBuilder(
            app,
            FavouritesDatabase::class.java,
            "favourites.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(db: FavouritesDatabase): DatabaseRepository {
        return DatabaseRepositoryImpl(db)
    }

}