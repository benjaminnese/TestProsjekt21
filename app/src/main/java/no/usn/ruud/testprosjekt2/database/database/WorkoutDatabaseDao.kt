package no.usn.ruud.testprosjekt2.database.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update


@Dao
interface WorkoutDatabaseDao {

//TODO Endre navn på alle til insertWorkout, insertExercise osv

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkout(workout: Workout)

    @Update
    fun updateWorkout(workout: Workout)

    @Query("SELECT * FROM workout WHERE workoutId = :arg0 LIMIT 1")//WHERE workoutId = :key"
    fun get(arg0: Long): LiveData<Workout>

//    @Query("SELECT * FROM Workout WHERE workoutId = :key")
//    suspend fun getID(key: Long): Workout?

    //  @Delete suspend fun clear():Int

    @Query("SELECT * FROM Workout")
    fun getAll(): LiveData<List<Workout>>

    @Query("SELECT * FROM exercises")
    fun getAllAsList(): LiveData<List<Exercise>>

//    @Query("SELECT EXISTS(SELECT 1 FROM workout WHERE workoutId = :workid LIMIT 1)")
//    suspend fun getLast(workid:String): Workout

//    @Delete
//     fun deleteAll()
//
//    @Query("DELETE FROM Workout WHERE workoutId = :key")
//    fun delete(key: Workout) {
//
//    }


//    @Query("DELETE FROM Workout")
//    suspend fun deleteAllWor()
//

    //---------------Exercise---------------------------//
    @Insert
    fun insertExercise(exercise: Exercise)

    @Query("SELECT * FROM exercises ORDER BY exerciseID ASC")
    fun getAllExercises(): LiveData<List<Exercise>>

    @Query("SELECT COUNT(workoutId) FROM workout")
    open fun getRowCount(): LiveData<Int>

    @Query("SELECT * FROM exercises WHERE exerciseID = :arg0")
    fun getExerciseplan(arg0: Long): LiveData<List<Exercise>>

//    @Query("SELECT * FROM workout WHERE workoutId = (SELECT MAX(workoutId) FROM workout) ")
//    suspend fun getLastExercise(): Exercise


//    @Query("DELETE FROM exercises")
//    suspend fun deleteAllEx()

    //---------------Join---------------------------//
    @Transaction
    @Query("SELECT * FROM exercises WHERE exerciseID IN (:arg0)")
    fun getAllExerciesFromWorkout(arg0: Long): LiveData<List<Exercise>>
}