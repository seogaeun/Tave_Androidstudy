package org.carrot.tave_androidstudy

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface TodoDAO {
    @Insert(onConflict = REPLACE)
    fun insert(todo : ToDoEntity)

    @Query("SELECT * FROM todo")
    fun getAll() : List<ToDoEntity>

    @Delete
    fun delete(todo: ToDoEntity)
}