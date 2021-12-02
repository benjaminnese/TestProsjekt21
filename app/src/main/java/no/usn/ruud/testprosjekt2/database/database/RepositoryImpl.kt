package no.usn.ruud.testprosjekt2.database.database

import android.util.Log
import androidx.lifecycle.LiveData

//https://blog.mindorks.com/room-database-with-kotlin-coroutines-in-android
//https://stackoverflow.com/questions/46847734/private-constructor-in-kotlin

//Using private to make object singleton with having to specify
class RepositoryImpl private constructor(
    private val workoutDatabaseDao: WorkoutDatabaseDao
) : Repository {

    //TODO endre alle til insertWorkout, insertExercise osv
    //API
    override suspend fun insertExercise(exercise: Exercise) {
        workoutDatabaseDao.insertExercise(exercise)
        Log.i("DatabaseHelperImpl", "insert kjørt")

    }

    override suspend fun insertWorkout(workout: Workout) {
        workoutDatabaseDao.insertWorkout(workout)
        Log.i("DatabaseHelperImpl", "insert kjørt")
    }

    override suspend fun updateWorkout(workout: Workout) {
        workoutDatabaseDao.updateWorkout(workout)
    }

    override suspend fun getRowCount(): LiveData<Int> {
        return workoutDatabaseDao.getRowCount()
    }

    override suspend fun getAll(): LiveData<List<Workout>> = workoutDatabaseDao.getAll()

    override suspend fun getAllAsList(): LiveData<List<Exercise>> =
        workoutDatabaseDao.getAllAsList()

    suspend fun getAllAsListExercise(): LiveData<List<Exercise>> =
        workoutDatabaseDao.getAllExercises()

    override suspend fun getAllExerciesFromWorkout(workout: Workout): LiveData<List<Exercise>> =
        workoutDatabaseDao.getAllExerciesFromWorkout(workout.workoutId)

    override suspend fun get(workoutId: Workout): LiveData<Workout> =
        workoutDatabaseDao.get(workoutId.workoutId.toLong())
//    override suspend fun delete(workout: Workout) {
//        workoutDatabaseDao.delete(workout)
//    }
//
//    override suspend fun deleteAllWorkouts() {
//        workoutDatabaseDao.deleteAll()
//    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }

    override suspend fun getLast(): Workout {
        TODO("Not yet implemented")
    }

    companion object {
        //TODO Blir logikken feil? Redd for at en repository kan lage krøll om det er mye data aksess
        private var workoutDatabaseDao: WorkoutDatabaseDao? = null

        // For Singleton instantiation
        @Volatile
        private var instance: RepositoryImpl? = null

        fun getInstance(workoutDatabaseDao: WorkoutDatabaseDao) =
            instance ?: synchronized(this) {
                instance ?: RepositoryImpl(workoutDatabaseDao).also { instance = it }
            }
    }
}
