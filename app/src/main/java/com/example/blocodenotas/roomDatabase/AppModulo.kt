package com.example.blocodenotas.roomDatabase

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModulo {

    @Provides
    @Singleton
    fun provideAnotacaoDao(
        @ApplicationContext context: Context
    ): AnotacaoDao = AppDatabase.getDatabase(context).anotacaoDao()
}