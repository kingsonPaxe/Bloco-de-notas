package com.example.blocodenotas.roomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anotacao")
data class Anotacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val descricao: String
)
