package com.example.blocodenotas.roomDatabase

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AnotacaoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnotacao(anotacao: Anotacao)

    @Query("SELECT * FROM anotacao")
    fun getAllAnotacoes(): Flow<List<Anotacao>>

    @Query("SELECT * FROM anotacao WHERE id = :id")
    suspend fun getAnotacaoById(id: Int): Anotacao?

    @Delete
    suspend fun deleteAnotacao(anotacao: Anotacao)
}
