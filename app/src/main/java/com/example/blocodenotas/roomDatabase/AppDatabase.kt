import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Anotacao::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun anotacaoDao(): AnotacaoDao
}