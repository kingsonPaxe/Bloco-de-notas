import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "bloco_de_notas_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
