package no.usn.ruud.testprosjekt2.database.database

import androidx.lifecycle.LiveData

interface Repository {
    suspend fun insertExercise(exercise: Exercise)
    suspend fun insertWorkout(workout: Workout)
    suspend fun updateWorkout(workout: Workout)
    suspend fun get(workout: Workout): LiveData<Workout>

    suspend fun getRowCount(): LiveData<Int>
    suspend fun getAll(): LiveData<List<Workout>>
    suspend fun getAllAsList(): LiveData<List<Exercise>>
    suspend fun getAllExerciesFromWorkout(workout: Workout): LiveData<List<Exercise>>

    //    suspend fun delete(workout: Workout)
//    suspend fun deleteAllWorkouts()
    suspend fun clear()
    suspend fun getLast(): Workout
}