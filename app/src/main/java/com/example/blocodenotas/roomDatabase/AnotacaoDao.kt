import androidx.room.*

@Dao
interface AnotacaoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnotacao(anotacao: Anotacao)

    @Query("SELECT * FROM anotacoes")
    suspend fun getAllAnotacoes(): List<Anotacao>

    @Query("SELECT * FROM anotacoes WHERE id = :id")
    suspend fun getAnotacaoById(id: Int): Anotacao?

    @Delete
    suspend fun deleteAnotacao(anotacao: Anotacao)
}
