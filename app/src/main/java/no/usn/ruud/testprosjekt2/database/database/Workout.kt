package no.usn.ruud.testprosjekt2.database.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout")//,
//        foreignKeys = [
//            ForeignKey(entity = Exercise::class, parentColumns = ["exerciseID"], childColumns = ["workoutId"])
//        ]
//        )
data class Workout(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "workoutId")
    var workoutId: Long = 0,
    @ColumnInfo(name = "date")
    var date: Long = 0,
)

