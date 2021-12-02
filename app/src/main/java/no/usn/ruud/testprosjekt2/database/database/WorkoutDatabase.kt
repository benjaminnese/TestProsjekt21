package no.usn.ruud.testprosjekt2.database.database
//
//import android.content.Context
//import android.util.Log
//import androidx.room.Database
//import androidx.room.Room.*
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import androidx.work.OneTimeWorkRequestBuilder
//import androidx.work.WorkManager
//import no.usn.ruud.testprosjekt2.database.database.Workout
//
//
////https://github.dev/android/sunflower/blob/compose/app/src/main/java/com/google/samples/apps/sunflower
//
//@Database(entities = [Workout::class, Exercise::class], version = 37, exportSchema = true)
////@TypeConverters(TimeConverters::class)
//abstract class WorkoutDatabase : RoomDatabase() {
//    abstract fun workoutDatabaseDao(): WorkoutDatabaseDao
//
//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: WorkoutDatabase? = null
//
//        fun getInstance(context: Context): WorkoutDatabase {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
//            }
//        }
//
//        //Builds database with function call to util/FillDatabaseWithContentWorker
//        //Using a synchronized worker created by Androidx.WorkManager since we only need
//        // to populate database with fill data on the initial commit
//        private fun buildDatabase(context: Context): WorkoutDatabase {
//            Log.i("Database", "Database blir opprettet")
//            return databaseBuilder(context, WorkoutDatabase::class.java, "workoutDB")
//                .addCallback(object : Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        val request =
//                            OneTimeWorkRequestBuilder<FillDatabaseWithContentWorker>().build()
//                        Log.i("Database: ", request.toString())
//                        WorkManager.getInstance(context).enqueue(request)
//                    }
//                }).fallbackToDestructiveMigration()
//                .build()
//        }
//
//        private fun fillExsistingDatabase(context: Context): WorkoutDatabase {
//            return databaseBuilder(context, WorkoutDatabase::class.java, "workoutDB")
//                .addCallback(object : Callback() {
//                    override fun onOpen(db: SupportSQLiteDatabase) {
//                        super.onOpen(db)
//                        val request =
//                            OneTimeWorkRequestBuilder<FillDatabaseWithContentWorker>().build()
//                        WorkManager.getInstance(context).enqueue(request)
//                    }
//                })
//                .build()
//        }
//    }
//}



