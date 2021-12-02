package no.usn.ruud.testprosjekt2.database.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exerciseID")
    val exerciseID: Long,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "sets")
    var sets: Long = 5,
    @ColumnInfo(name = "reps")
    var reps: Long = 5,
)


