package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.db.AppDatabase
import com.example.myapplication.data.db.dao.MedicineDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): MedicineDao {
        return database.MedicineDao()
    }
}