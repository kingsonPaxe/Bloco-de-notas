package com.example.blocodenotas.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Anotacao::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun anotacaoDao(): AnotacaoDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "bloco_de_notas_database"
                ).build()
                    .also {
                        instance = it
                    }
            }
        }
    }


}