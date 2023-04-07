package org.carrot.tave_androidstudy
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="todo")
data class ToDoEntity(
    @PrimaryKey(autoGenerate=true)
    var id: Long? = 0,
    var todo: String="")


